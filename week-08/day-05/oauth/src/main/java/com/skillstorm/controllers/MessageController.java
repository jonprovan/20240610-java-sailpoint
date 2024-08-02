package com.skillstorm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Message;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@GetMapping("/public")
	public Message getPublicMessage() {
		return new Message("Public message successfully retrieved!");
	}
	
	@GetMapping("/private")
	public Message getPrivateMessage() {
		return new Message("Private message successfully retrieved!");
	}
	
}