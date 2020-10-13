package com.cognizant.collector.jira.scheduler;

import com.cognizant.collector.jira.component.JiraIssueComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSchedulerImpl implements BatchEvents {
    @Autowired
    private JiraIssueComponent component;

    @Override
    public void beforeJob() {
        log.info("Before Job process........!");
        component.getJiraIssues();
    }

    @Override
    public void beforeTask() {
        log.info("Before Task process........!");
    }

    @Override
    public void afterTask() {
        log.info("After Task process........!");
    }

    @Override
    public void afterJob() {
        log.info("After Job process........!");
    }
}