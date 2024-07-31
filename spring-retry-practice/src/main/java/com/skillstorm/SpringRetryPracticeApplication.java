package com.skillstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringRetryPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRetryPracticeApplication.class, args);
	}

}
