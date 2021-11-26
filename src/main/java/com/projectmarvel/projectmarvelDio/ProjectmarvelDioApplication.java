package com.projectmarvel.projectmarvelDio;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class ProjectmarvelDioApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectmarvelDioApplication.class, args);
		System.out.println("Super Poweres with Web Flux");
	}

}
