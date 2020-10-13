package com.cognizant.collector.jira.beans.core;

import lombok.Data;

import java.util.Date;

@Data
public class FixVersion {
    private String id;
    private String name;
    private boolean archived;
    private boolean released;
    private Date releaseDate;
}
