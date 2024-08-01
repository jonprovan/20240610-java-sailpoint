package com.skillstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsRecommendationsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRecommendationsServiceApplication.class, args);
	}

}
