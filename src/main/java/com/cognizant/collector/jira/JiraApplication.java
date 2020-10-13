package com.cognizant.collector.jira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@SpringBootApplication
@EnableScheduling
public class JiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiraApplication.class, args);
	}

}
