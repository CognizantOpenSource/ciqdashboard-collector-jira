/*
 *  © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.cognizant.collector.jira.issues;

import com.cognizant.collector.jira.beans.core.SprintDetails;
import com.cognizant.collector.jira.component.CommonUtilComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * SprintDetailsTest
 * @author Cognizant
 */

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
        Assertions.assertNotNull(sprintDetails);
    }


}
