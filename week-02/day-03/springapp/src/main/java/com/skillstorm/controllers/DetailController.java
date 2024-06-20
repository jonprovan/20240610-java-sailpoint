package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Detail;
import com.skillstorm.services.DetailService;

@RestController
@RequestMapping("/detail")
@CrossOrigin(origins = "*")
public class DetailController {
	
	@Autowired
	private DetailService service;
	
	// get all
	@GetMapping
	public Iterable<Detail> getAllDetails() {
		return service.getAllDetails();
	}

}
