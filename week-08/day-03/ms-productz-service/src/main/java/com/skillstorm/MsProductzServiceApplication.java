package com.skillstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // Similar ComponentScan. Looks for interfaces 
// declared with @FeignClient and will create a proxy class that implements it
public class MsProductzServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProductzServiceApplication.class, args);
	}

}
