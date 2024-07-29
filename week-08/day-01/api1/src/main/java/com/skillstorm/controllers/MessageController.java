package com.skillstorm.controllers;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.skillstorm.models.Message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*")
public class MessageController {
	
	// this annotation draws the value of this variable from the application.properties file and assigns it to the variable
	@Value("${api2.username}")
	private String username;
	
	@Value("${api2.password}")
	private String password;
	
	@GetMapping()
	public Message getMessage() {
		return new Message("GET request to /message was successful!");
	}
	
	@GetMapping("/specific")
	public Message getSpecificMessage() {
		return new Message("GET request to /message/specific was successful!");
	}
	
	@GetMapping("/api2")
	public ResponseEntity<String> getAPI2Message() {
		
		// to make a call to another API, we use a RestTemplate
		// this is, as it sounds, a template for basic REST API calls we can fill in with our specific information
		RestTemplate template = new RestTemplate();
		// since auth info lives in the header, we need a header object
		HttpHeaders headers = new HttpHeaders();
		// then, we need to encode our username and password for inclusion in the headers
		// syntax... key = "Authorization" value = "Basic <encoded version of username:password>"
		String authString = Base64.getEncoder().encodeToString( (username + ":" + password).getBytes() );
		// adding this header
		headers.add("Authorization", "Basic " + authString);
		// creating an entity to hold our headers
		HttpEntity<String> entity = new HttpEntity<>(headers);
		// executing the request
		// the .exchange method executes the request, and that's what we're returning in this case
		// parameters = the URL of the other API, the method type, the HttpEntity, and the class of the returned item(s)
		return template.exchange("http://localhost:8082/message", HttpMethod.GET, entity, String.class);
	}
	
	
//	@PostMapping("/post")
//	public Message postSpecificMessage(@RequestBody String str) {
//		return new Message("POST request to /message/specific was successful!");
//	}
	
	
	
	
	
}