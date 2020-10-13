package com.cognizant.collector.jira.beans.core;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "expand",
        "id",
        "self",
        "key",
        "fields"
})
public class JiraIssueInfo {

    @JsonProperty("expand")
    private String expand;
    @JsonProperty("id")
    private String id;
    @JsonProperty("self")
    private String self;
    @JsonProperty("key")
    private String key;
    @JsonProperty("fields")
    private Fields fields;
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
    public JiraIssue getJiraIssue(){
        JiraIssue issue = new JiraIssue();
        BeanUtils.copyProperties(this, issue);
        issue = this.fields.getJiraIssue(issue);

        return issue;
    }

}
