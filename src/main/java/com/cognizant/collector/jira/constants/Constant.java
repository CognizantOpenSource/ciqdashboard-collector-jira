package com.cognizant.collector.jira.constants;

public class Constant {

    public static final int RESULTS_PER_PAGE = 1000;
    public static final int PAGE_STARTS_AT = 0;
    public static final String MAX_RESULTS = "maxResults";
    public static final String START_AT = "startAt";
    public static final String PROJECT = "project='%s'";
    public static final String JQL_UPDATED_LT = "updated < '%s' ";
    public static final String JQL_UPDATED_GTE = "updated >= '%s' ";
    public static final String JQL_AND = " AND ";
    public static final String JQL = "jql";

    private Constant() {
    }
}
