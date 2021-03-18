/*
 *  © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

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
/**
 * JiraIssuesTest
 * @author Cognizant
 */

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
