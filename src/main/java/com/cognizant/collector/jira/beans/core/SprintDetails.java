package com.cognizant.collector.jira.beans.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SprintDetails {
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

}
