package com.cognizant.collector.jira.beans.core;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "self",
        "name",
        "key",
        "emailAddress",
        "avatarUrls",
        "displayName",
        "active",
        "timeZone"
})
public class User {

    @JsonProperty("self")
    private String self;
    @JsonProperty("name")
    private String name;
    @JsonProperty("key")
    private String key;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("avatarUrls")
    private Map<String, String> avatarUrls;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("timeZone")
    private String timeZone;
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