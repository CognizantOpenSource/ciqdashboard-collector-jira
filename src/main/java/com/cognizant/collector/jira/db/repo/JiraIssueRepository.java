package com.cognizant.collector.jira.db.repo;

import com.cognizant.collector.jira.beans.core.JiraIssue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JiraIssueRepository extends MongoRepository<JiraIssue, String> {
    JiraIssue findFirstByProjectKeyOrderByUpdatedDesc(String projectKey);
}
