package com.cognizant.collector.jira.config;


import com.cognizant.collector.jira.client.JiraClient;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;


@Configuration
@Slf4j
public class GlobalConfiguration {

    private static final String AUTHORIZATION = "Authorization";

    @Value("${jiraServer.url}")
    private String jiraServerUrl;
    @Value("${jiraServer.username}")
    private String jiraServerUsername;
    @Value("${jiraServer.password}")
    private String jiraServerPassword;

    @Bean
    public JiraClient jiraClient() {

        return Feign.builder()
                .requestInterceptor(new BasicAuthRequestInterceptor(jiraServerUsername, jiraServerPassword))
                .contract(new SpringMvcContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .client(new OkHttpClient())
                .options(new Request.Options(20000, TimeUnit.MILLISECONDS, 20000, TimeUnit.MILLISECONDS, true))
                .logger(new Slf4jLogger(JiraClient.class))
                .logLevel(Logger.Level.FULL)
                .target(JiraClient.class,jiraServerUrl);
    }

}


