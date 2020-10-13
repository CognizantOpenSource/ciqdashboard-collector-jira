package com.cognizant.collector.jira.client;

import com.cognizant.collector.jira.beans.Project;
import com.cognizant.collector.jira.beans.core.JiraIssueDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface JiraClient {

    @GetMapping("/project")
    List<Project> getJiraProjects();

    @GetMapping("/search")
    JiraIssueDetails getJiraIssues(@RequestParam Map<String, String> requestParams);

}
