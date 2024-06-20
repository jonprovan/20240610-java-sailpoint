package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Detail;
import com.skillstorm.repositories.DetailRepository;

@Service
public class DetailService {
	
	@Autowired
	private DetailRepository repo;
	
	// get all
	public Iterable<Detail> getAllDetails() {
		return repo.findAll();
	}

}
