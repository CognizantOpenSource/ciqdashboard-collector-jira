package com.cognizant.collector.jira.beans.core;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "jiraIssues")
public class JiraIssue {

    @Id
    private String id;
    private String expand;
    private String self;
    private String key;

    /* Fields */

    /* project */
    private String projectSelf;
    private String projectId;
    private String projectKey;
    private String projectName;
    private String projectTypeKey;
    private Map<String, String> projectAvatarUrls;
    /* project */

    /* issueType */
    private String issueTypeSelf;
    private String issueTypeId;
    private String issueTypeDescription;
    private String issueTypeIconUrl;
    private String issueTypeName;
    private Boolean issueTypeSubtask;
    private Integer issueTypeAvatarId;
    /* issueType */

    /*components*/
    private String componentId;
    private String componentName;
    /*components*/

    private Object timeSpent;
    private Object timeOriginalEstimate;
    private String description;

    /*Fix Version*/
    private String fixVersionId;
    private String fixVersionName;
    private boolean fixVersionArchived;
    private boolean fixVersionReleased;
    private Date fixVersionReleaseDate;
    /*Fix Version*/

    private Object aggregateTimeSpent;
    private Object timeTracking;
    private List<String> customField10104 = null;
    private Object customField10203;
    private Object customField10105;
    private List<Object> attachment = null;
    private Object aggregateTimeEstimate;
    private Date resolutionDate;
    private Integer workRatio;
    private String summary;
    private Object lastViewed;
    private Object watches;
    private List<Object> subTasks = null;
    private Object customField10000;
    private Object aggregateProgress;

    /* Priority */
    private String priority;
    private String priorityId;
    /* Priority */

    private Object customField10100;
//    private Object customField10201;
    private List<Object> labels = null;
    private Object customField10202;
    private Object environment;
    private Object timeEstimate;
    private Object aggregateTimeOriginalEstimate;
    private List<Object> versions = null;
    private Object dueDate;
    private Object progress;
    private Object comment;
    private List<Object> issueLinks = null;
    private Object votes;
    private Object workLog;

    private Date created;
    private Date updated;

    /* Sprint Details */
    private Integer sprintId;
    private Integer sprintRapidViewId;
    private String sprintState;
    private String sprintName;
    private Integer sprintSequence;
    private Object sprintGoal;
    private Date sprintStartDate;
    private Date sprintEndDate;
    private Date sprintCompleteDate;
    private Date sprintActivatedDate;
    /* Sprint Details */

    /* creator */
    private String creatorSelf;
    private String creatorName;
    private String creatorKey;
    private String creatorEmailAddress;
    private Map<String, String> creatorAvatarUrls;
    private String creatorDisplayName;
    private Boolean creatorActive;
    private String creatorTimeZone;
    /* creator */

    /* reporter */
    private String reporterSelf;
    private String reporterName;
    private String reporterKey;
    private String reporterEmailAddress;
    private Map<String, String> reporterAvatarUrls;
    private String reporterDisplayName;
    private Boolean reporterActive;
    private String reporterTimeZone;
    /* reporter */

    /* assignee */
    private String assigneeSelf;
    private String assigneeName;
    private String assigneeKey;
    private String assigneeEmailAddress;
    private Map<String, String> assigneeAvatarUrls;
    private String assigneeDisplayName;
    private Boolean assigneeActive;
    private String assigneeTimeZone;
    /* assignee */

    /* resolution */
    private String resolutionSelf;
    private String resolutionId;
    private String resolutionDescription;
    private String resolutionName;
    /* resolution */

    /* status */
    private String statusSelf;
    private String statusDescription;
    private String statusIconUrl;
    private String statusName;
    private String statusId;

    /* statusCategory */
    private String statusCategorySelf;
    private Integer statusCategoryId;
    private String statusCategoryKey;
    private String statusCategoryColorName;
    private String statusCategoryName;
    /* statusCategory */
    /* status */

    /* Fields */
    private String customField10204;
    private String customField10205;
    private String customField10206;
    private String customField10207;
    private String customField10208;
    private String customField10201;

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
}

