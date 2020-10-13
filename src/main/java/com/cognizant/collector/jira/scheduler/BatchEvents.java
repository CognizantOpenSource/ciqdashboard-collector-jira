package com.cognizant.collector.jira.scheduler;

public interface BatchEvents {
    void beforeJob();
    void beforeTask();
    void afterTask();
    void afterJob();
}
