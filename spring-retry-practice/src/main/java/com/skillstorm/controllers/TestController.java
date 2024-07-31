package com.skillstorm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.services.TestService;

@RestController
public class TestController {

	private final TestService testService;
	
	public TestController(TestService testService) {
		this.testService = testService;
	}
	
	@GetMapping("/random")
	public double getRandomNumber() {
		return testService.getRandomNumber();
	}
}
