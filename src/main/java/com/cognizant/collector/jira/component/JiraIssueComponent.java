package com.cognizant.collector.jira.component;

import com.cognizant.collector.jira.beans.Project;
import com.cognizant.collector.jira.beans.core.*;
import com.cognizant.collector.jira.client.JiraClient;
import com.cognizant.collector.jira.service.JiraIssueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.cognizant.collector.jira.constants.Constant.*;

@Component
@Slf4j
public class JiraIssueComponent {

    @Autowired
    JiraIssueService service;
    @Autowired
    JiraClient client;
    @Autowired
    CommonUtilComponent utilComponent;

    public List<Project> getProjects() {
        return client.getJiraProjects();
    }

    public JiraIssueDetails getIssues(Map<String, String> requestParam) {
        return client.getJiraIssues(requestParam);
    }

    private List<JiraIssue> saveAllIssuesInDB(List<JiraIssue> issues) {
        return service.addAll(issues);
    }

    private void getIssuesAndStoreInDB(List<JiraIssueInfo> issueInfoList) {
        List<JiraIssue> issues = issueInfoList.stream().map(jiraIssueInfo -> {
            IssueType issueType = jiraIssueInfo.getFields().getIssuetype();
            List<String> customfield_10101 = jiraIssueInfo.getFields().getCustomfield_10101();
            if (issueType !=null && !CollectionUtils.isEmpty(customfield_10101)){
                String customField = customfield_10101.get(0);
                SprintDetails sprintDetails = utilComponent.getSprintDetailsFromString(customField);
                jiraIssueInfo.getFields().setSprintDetails(sprintDetails);
            }
            return jiraIssueInfo.getJiraIssue();
        }).collect(Collectors.toList());
        List<JiraIssue> jiraIssues = saveAllIssuesInDB(issues);
        log.info("JiraIssues stored in DB, Count: {}", jiraIssues.size());
    }

    private void getAllIssuesByProject(Project project) {
        Map<String, String> map = new HashMap<>();
        int resultPerPage = RESULTS_PER_PAGE;
        int startAt = PAGE_STARTS_AT;
        boolean isCompleted = false;
        Date maxUpdatedDate = service.getMaxUpdatedDate(project.getKey());
        String jqlParamString = utilComponent.getJqlParamString(project.getKey(), maxUpdatedDate);
        map.put(JQL, jqlParamString);
        map.put(MAX_RESULTS, String.valueOf(resultPerPage));
        do {
            map.put(START_AT, String.valueOf(startAt));
            log.info("StartAt:{}, MaxResult:{}, JqlString:{}", startAt, resultPerPage, jqlParamString);
            JiraIssueDetails issues = getIssues(map);
            List<JiraIssueInfo> issueInfoList = issues.getIssues();
            if (CollectionUtils.isEmpty(issueInfoList)) {
                isCompleted = true;
            } else {
                startAt += resultPerPage;
                if (issues.getTotal() < startAt) isCompleted = true;
                log.info("Issues count form server : {}", issueInfoList.size());
                getIssuesAndStoreInDB(issueInfoList);
            }
        } while (!isCompleted);
    }

    public void getJiraIssues() {
        List<Project> projects = getProjects();
        projects.forEach(project -> {
            log.info("********* Project Name: {}", project.getName());
            getAllIssuesByProject(project);
        });
    }

}
