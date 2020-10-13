package com.cognizant.collector.jira.service;

import com.cognizant.collector.jira.beans.core.JiraIssue;
import com.cognizant.collector.jira.db.repo.JiraIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JiraIssueService {
    @Autowired
    JiraIssueRepository repository;

    public List<JiraIssue> getAll() {
        return repository.findAll();
    }

    public Optional<JiraIssue> get(String id) {
        return repository.findById(id);
    }

    public JiraIssue add(JiraIssue issue){
        return repository.save(issue);
    }

    public List<JiraIssue> addAll(List<JiraIssue> issues){
        return repository.saveAll(issues);
    }

    public Date getMaxUpdatedDate(String projectKey){
        JiraIssue first = repository.findFirstByProjectKeyOrderByUpdatedDesc(projectKey);
        return first == null ? null : first.getUpdated();
    }


}
