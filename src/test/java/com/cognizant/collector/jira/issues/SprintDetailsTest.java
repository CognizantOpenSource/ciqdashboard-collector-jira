package com.cognizant.collector.jira.issues;

import com.cognizant.collector.jira.beans.core.SprintDetails;
import com.cognizant.collector.jira.component.CommonUtilComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SprintDetailsTest {
    private static final String sprintDetails = "com.atlassian.greenhopper.service.sprint.Sprint@1db805ab[id=34,rapidViewId=1,state=FUTURE," +
            "name=Sample Sprint 4,startDate=2020-08-10T02:21:00.000Z,endDate=2020-08-24T02:21:00.000Z,completeDate=<null>,activatedDate=<null>," +
            "sequence=34,goal=<null>]";

    @Autowired
    CommonUtilComponent utilComponent;

    @Test
    void regexTest() {
        SprintDetails sprintDetails = utilComponent.getSprintDetailsFromString(SprintDetailsTest.sprintDetails);
        Assertions.assertNotNull(utilComponent);
    }


}
