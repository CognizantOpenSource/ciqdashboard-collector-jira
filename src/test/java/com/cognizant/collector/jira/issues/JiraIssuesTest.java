package com.cognizant.collector.jira.issues;

import com.cognizant.collector.jira.beans.Project;
import com.cognizant.collector.jira.client.JiraClient;
import com.cognizant.collector.jira.service.JiraIssueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class JiraIssuesTest {

    @Autowired
    JiraClient jiraClient;
    @Autowired
    JiraIssueService service;

    @Test
    void getProjectTest(){
        List<Project> projects = jiraClient.getJiraProjects();
//        System.out.println("projects");
        Assertions.assertNotNull(projects);
    }

    @Test
    void getMaxUpdatedDate(){
        List<Project> projects = jiraClient.getJiraProjects();
        projects.forEach(project -> {
            Date maxUpdatedDate = service.getMaxUpdatedDate(project.getKey());
//            System.out.println(maxUpdatedDate);
            Assertions.assertNotNull(maxUpdatedDate);
        });
        Assertions.assertNotNull(projects);
    }

}
