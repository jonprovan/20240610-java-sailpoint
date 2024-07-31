package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.utils.CustomHealthCheck;

@RestController
public class FallbackController {
	
	@Autowired
	private CustomHealthCheck customHealthCheck;

	@GetMapping("/fallback/products")
	public String cache() {
		customHealthCheck.setIsHealthy(false);
		return "cached products";
	}
}
