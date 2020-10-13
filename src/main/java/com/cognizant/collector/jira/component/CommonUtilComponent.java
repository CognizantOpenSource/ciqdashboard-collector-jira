package com.cognizant.collector.jira.component;

import com.cognizant.collector.jira.beans.core.SprintDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.cognizant.collector.jira.constants.Constant.*;

@Component
@Slf4j
public class CommonUtilComponent {

    public String parseDateToString(Date date) {
        if (null == date) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    public Date getDateFromString(String dateString) {
        Date date = null;
        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
            date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            log.info("Return value as null, due to exception while parsing string to date, Exception:{}", e.getLocalizedMessage());
        }
        return date;
    }

    public Integer getIntegerFromString(String integerString) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(integerString);
        } catch (Exception e) {
            log.info("Return value as null, due to exception while parsing string to integer, Exception:{}", e.getLocalizedMessage());
        }
        return integer;
    }

    public Map<String, String> getMap(String input) {
        Map<String, String> map = new HashMap<>();
        if (!(input.contains("[") && input.contains("]"))) return map;

        String[] strings = input.substring(input.indexOf('[') + 1, input.indexOf(']')).split(",");
        List<String> list = Arrays.asList(strings);
        list.forEach(s -> {
            String[] split = s.split("=");
            String key = split[0];
            if (split.length == 2) {
                String value = split[1].equals("<null>") ? null : split[1];
                map.put(key, value);
            }
        });

        return map;
    }

    public String getJqlParamString(String projectKey, Date lastUpdatedDate) {
        List<String> jqlParams = new ArrayList<>();
        jqlParams.add(String.format(PROJECT, projectKey));

        Date now = Calendar.getInstance().getTime();
        String nowDateSting = parseDateToString(now);
        jqlParams.add(String.format(JQL_UPDATED_LT, nowDateSting));
        if (!StringUtils.isEmpty(lastUpdatedDate)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(lastUpdatedDate);
            calendar.add(Calendar.MINUTE, 1);
            String updatedDateString = parseDateToString(calendar.getTime());
            jqlParams.add(String.format(JQL_UPDATED_GTE, updatedDateString));
        }

        String jqlString = jqlParams.stream().collect(Collectors.joining(JQL_AND));
        log.info("JQL string : " + jqlString);
        return jqlString;
    }

    public SprintDetails getSprintDetailsFromString(String input){
        if (StringUtils.isEmpty(input)) return null;
        SprintDetails sprintDetails = new SprintDetails();
        Map<String, String> map = getMap(input);
        String id = map.get("id");
        String rapidViewId = map.get("rapidViewId");
        String state = map.get("state");
        String name = map.get("name");
        String startDate = map.get("startDate");
        String endDate = map.get("endDate");
        String completeDate = map.get("completeDate");
        String activatedDate = map.get("activatedDate");
        String sequence = map.get("sequence");
        String goal = map.get("goal");

        sprintDetails.setSprintId(getIntegerFromString(id));
        sprintDetails.setSprintRapidViewId(getIntegerFromString(rapidViewId));
        sprintDetails.setSprintSequence(getIntegerFromString(sequence));

        sprintDetails.setSprintActivatedDate(getDateFromString(activatedDate));
        sprintDetails.setSprintCompleteDate(getDateFromString(completeDate));
        sprintDetails.setSprintEndDate(getDateFromString(endDate));
        sprintDetails.setSprintStartDate(getDateFromString(startDate));

        sprintDetails.setSprintGoal(goal);
        sprintDetails.setSprintName(name);
        sprintDetails.setSprintState(state);

        return sprintDetails;
    }
}
