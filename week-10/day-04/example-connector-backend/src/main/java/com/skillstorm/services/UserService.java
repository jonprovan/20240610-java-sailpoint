package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.User;
import com.skillstorm.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	// get all
	public Iterable<User> getAllUsers() {
		return repo.findAll();
	}
	
	// get by ID
	public User getById(int id) {
		return repo.findById(id).get();
	}
	
	// create one
	public User createUser(User user) {
		user.setId(0);
		return repo.save(user);
	}

}
