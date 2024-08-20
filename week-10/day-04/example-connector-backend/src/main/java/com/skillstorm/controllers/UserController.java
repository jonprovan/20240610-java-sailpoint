package com.skillstorm.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.User;
import com.skillstorm.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	// get all
	@GetMapping
	public Iterable<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	// get by ID
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	// create one
	@PostMapping
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	// test connection
	@GetMapping("/test")
	public String testConnection() {
		System.out.println("*************** Connection Initiated ******************");
		return "Connection to Example Connector Backend successful!!";
	}
	
	// updating a User
	@PutMapping
	public User updateUser(@RequestBody Map<String, Object> body) {
		
		System.out.println(body);
		
		return service.updateUser(body);
	}
	
	
	

}
