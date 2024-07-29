package com.skillstorm.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Message;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*")
public class MessageController {
	
	@GetMapping()
	public Message getMessage() {
		return new Message("GET request to second API was successful!!");
	}

}
