package com.cognizant.collector.jira.beans.core;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "issuetype",
        "components",
        "timespent",
        "timeoriginalestimate",
        "description",
        "project",
        "fixVersions",
        "aggregatetimespent",
        "resolution",
        "timetracking",
        "customfield_10104",
        "customfield_10203",
        "customfield_10105",
        "attachment",
        "aggregatetimeestimate",
        "resolutiondate",
        "workratio",
        "summary",
        "lastViewed",
        "watches",
        "creator",
        "subtasks",
        "created",
        "reporter",
        "customfield_10000",
        "aggregateprogress",
        "priority",
        "customfield_10100",
        "customfield_10201",
        "labels",
        "customfield_10202",
        "environment",
        "timeestimate",
        "aggregatetimeoriginalestimate",
        "versions",
        "duedate",
        "progress",
        "comment",
        "issuelinks",
        "votes",
        "worklog",
        "assignee",
        "updated",
        "status"
})
public class Fields {

    @JsonProperty("issuetype")
    private IssueType issuetype;
    @JsonProperty("components")
    private List<Object> components = null;
    @JsonProperty("timespent")
    private Object timeSpent;
    @JsonProperty("timeoriginalestimate")
    private Object timeOriginalEstimate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("fixVersions")
    private List<FixVersion> fixVersions = null;
    @JsonProperty("aggregatetimespent")
    private Object aggregateTimeSpent;
    @JsonProperty("resolution")
    private Resolution resolution;
    @JsonProperty("timetracking")
    private Object timeTracking;
    @JsonProperty("customfield_10104")
    private List<String> customField10104 = null;
    @JsonProperty("customfield_10203")
    private Object customField10203;
    @JsonProperty("customfield_10105")
    private Object customField10105;
    @JsonProperty("attachment")
    private List<Object> attachment = null;
    @JsonProperty("aggregatetimeestimate")
    private Object aggregateTimeEstimate;
    @JsonProperty("resolutiondate")
    private String resolutionDate;
    @JsonProperty("workratio")
    private Integer workRatio;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("lastViewed")
    private Object lastViewed;
    @JsonProperty("watches")
    private Object watches;
    @JsonProperty("creator")
    private User creator;
    @JsonProperty("subtasks")
    private List<Object> subTasks = null;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("reporter")
    private User reporter;
    @JsonProperty("customfield_10000")
    private Object customField10000;
    @JsonProperty("aggregateprogress")
    private Object aggregateProgress;
    @JsonProperty("priority")
    private Object priority;
    @JsonProperty("customfield_10100")
    private Object customField10100;
    @JsonProperty("customfield_10201")
    private Object customField10201;
    @JsonProperty("labels")
    private List<Object> labels = null;
    @JsonProperty("customfield_10202")
    private Object customField10202;
    @JsonProperty("environment")
    private Object environment;
    @JsonProperty("timeestimate")
    private Object timeEstimate;
    @JsonProperty("aggregatetimeoriginalestimate")
    private Object aggregateTimeOriginalEstimate;
    @JsonProperty("versions")
    private List<Object> versions = null;
    @JsonProperty("duedate")
    private Object dueDate;
    @JsonProperty("progress")
    private Object progress;
    @JsonProperty("comment")
    private Object comment;
    @JsonProperty("issuelinks")
    private List<Object> issueLinks = null;
    @JsonProperty("votes")
    private Object votes;
    @JsonProperty("worklog")
    private Object workLog;
    @JsonProperty("assignee")
    private User assignee;
    @JsonProperty("updated")
    private Date updated;
    @JsonProperty("status")
    private Status status;
    private SprintDetails sprintDetails;
    @JsonProperty("customfield_10204")
    private Object customField10204;
    @JsonProperty("customfield_10205")
    private Object customField10205;
    @JsonProperty("customfield_10206")
    private Object customField10206;
    @JsonProperty("customfield_10207")
    private Object customField10207;
    @JsonProperty("customfield_10208")
    private Object customField10208;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonIgnore
    public JiraIssue getJiraIssue(JiraIssue issue) {
        BeanUtils.copyProperties(this, issue);

        this.setJiraIssueProject(issue);
        this.setJiraIssueIssueType(issue);
        this.setJiraIssueCreator(issue);
        this.setJiraIssueReporter(issue);
        this.setJiraIssueAssignee(issue);
        this.setJiraIssueResolution(issue);
        this.setJiraIssueStatus(issue);
        this.setJiraIssueSprintDetails(issue);
        this.setCustomField(issue);
        this.setJiraIssuePriority(issue);
        this.setJiraIssueFixVersion(issue);
        this.setJiraIssueComponents(issue);
        return issue;
    }

    private JiraIssue setCustomField(JiraIssue issue) {
        String value = "value";

        if (null != customField10204) issue.setCustomField10204((String) ((Map) customField10204).get(value));
        if (null != customField10205) issue.setCustomField10205((String) ((Map) customField10205).get(value));
        if (null != customField10206) issue.setCustomField10206((String) ((Map) customField10206).get(value));
        if (null != customField10207) issue.setCustomField10207((String) ((Map) customField10207).get(value));
        if (null != customField10208) issue.setCustomField10208((String) ((Map) customField10208).get(value));
        if (null != customField10201) issue.setCustomField10201((String) ((Map) customField10201).get(value));
        return issue;
    }

    private JiraIssue setJiraIssueSprintDetails(JiraIssue issue) {
        if (null == sprintDetails) return issue;
        issue.setSprintActivatedDate(sprintDetails.getSprintActivatedDate());
        issue.setSprintCompleteDate(sprintDetails.getSprintCompleteDate());
        issue.setSprintEndDate(sprintDetails.getSprintEndDate());
        issue.setSprintGoal(sprintDetails.getSprintGoal());
        issue.setSprintId(sprintDetails.getSprintId());
        issue.setSprintName(sprintDetails.getSprintName());
        issue.setSprintRapidViewId(sprintDetails.getSprintRapidViewId());
        issue.setSprintSequence(sprintDetails.getSprintSequence());
        issue.setSprintStartDate(sprintDetails.getSprintStartDate());
        issue.setSprintState(sprintDetails.getSprintState());

        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueStatus(JiraIssue issue) {
        /* status */
        if (null == status) return issue;
        issue.setStatusDescription(status.getDescription());
        issue.setStatusIconUrl(status.getIconUrl());
        issue.setStatusId(status.getId());
        issue.setStatusName(status.getName());
        issue.setStatusSelf(status.getSelf());

        /* statusCategory */
        StatusCategory statusCategory = status.getStatusCategory();
        if (null == statusCategory) return issue;
        issue.setStatusCategoryColorName(statusCategory.getColorName());
        issue.setStatusCategoryId(statusCategory.getId());
        issue.setStatusCategoryKey(statusCategory.getKey());
        issue.setStatusCategoryName(statusCategory.getName());
        issue.setStatusCategorySelf(statusCategory.getSelf());
        /* statusCategory */
        /* status */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueResolution(JiraIssue issue) {
        /* resolution */
        if (null == resolution) return issue;
        issue.setResolutionDescription(resolution.getDescription());
        issue.setResolutionId(resolution.getId());
        issue.setResolutionName(resolution.getName());
        issue.setResolutionSelf(resolution.getSelf());
        /* resolution */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueAssignee(JiraIssue issue) {
        /* assignee */
        if (null == assignee) return issue;
        issue.setAssigneeActive(assignee.getActive());
        issue.setAssigneeAvatarUrls(assignee.getAvatarUrls());
        issue.setAssigneeDisplayName(assignee.getDisplayName());
        issue.setAssigneeEmailAddress(assignee.getEmailAddress());
        issue.setAssigneeKey(assignee.getKey());
        issue.setAssigneeName(assignee.getName());
        issue.setAssigneeSelf(assignee.getSelf());
        issue.setAssigneeTimeZone(assignee.getTimeZone());
        /* assignee */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueReporter(JiraIssue issue) {
        /* reporter */
        if (null == reporter) return issue;
        issue.setReporterActive(reporter.getActive());
        issue.setReporterAvatarUrls(reporter.getAvatarUrls());
        issue.setReporterDisplayName(reporter.getDisplayName());
        issue.setReporterEmailAddress(reporter.getEmailAddress());
        issue.setReporterKey(reporter.getKey());
        issue.setReporterName(reporter.getName());
        issue.setReporterSelf(reporter.getSelf());
        issue.setReporterTimeZone(reporter.getTimeZone());
        /* reporter */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueCreator(JiraIssue issue) {
        /* creator */
        if (null == creator) return issue;
        issue.setCreatorActive(creator.getActive());
        issue.setCreatorAvatarUrls(creator.getAvatarUrls());
        issue.setCreatorDisplayName(creator.getDisplayName());
        issue.setCreatorEmailAddress(creator.getEmailAddress());
        issue.setCreatorKey(creator.getKey());
        issue.setCreatorName(creator.getName());
        issue.setCreatorSelf(creator.getSelf());
        issue.setCreatorTimeZone(creator.getTimeZone());
        /* creator */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueIssueType(JiraIssue issue) {
        /* issueType */
        IssueType issueType = this.issuetype;
        if (null == issueType) return issue;
        issue.setIssueTypeId(issueType.getId());
        issue.setIssueTypeSelf(issueType.getSelf());
        issue.setIssueTypeName(issueType.getName());
        issue.setIssueTypeAvatarId(issueType.getAvatarId());
        issue.setIssueTypeDescription(issueType.getDescription());
        issue.setIssueTypeIconUrl(issueType.getIconUrl());
        issue.setIssueTypeSubtask(issueType.getSubtask());
        /* issueType */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueProject(JiraIssue issue) {
        /* project */
        if (null == project) return issue;
        issue.setProjectId(project.getId());
        issue.setProjectKey(project.getKey());
        issue.setProjectName(project.getName());
        issue.setProjectSelf(project.getSelf());
        issue.setProjectAvatarUrls(project.getAvatarUrls());
        issue.setProjectTypeKey(project.getProjectTypeKey());
        /* project */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssuePriority(JiraIssue issue) {
        if (priority == null) return issue;
        issue.setPriority((String) ((Map) priority).get("name"));
        issue.setPriorityId((String) ((Map) priority).get("id"));
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueFixVersion(JiraIssue issue) {
        if (fixVersions == null || fixVersions.size() <= 0) return issue;
        issue.setFixVersionId(fixVersions.stream().findFirst().get().getId());
        issue.setFixVersionName(fixVersions.stream().findFirst().get().getName());
        issue.setFixVersionArchived(fixVersions.stream().findFirst().get().isArchived());
        issue.setFixVersionReleased(fixVersions.stream().findFirst().get().isReleased());
        issue.setFixVersionReleaseDate(fixVersions.stream().findFirst().get().getReleaseDate());
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueComponents(JiraIssue issue) {
        if (components == null || components.size() <= 0) return issue;
        issue.setComponentId((String) ((Map) components.get(0)).get("id"));
        issue.setComponentName((String) ((Map) components.get(0)).get("name"));
        return issue;
    }
}

