package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Certification;
import com.skillstorm.repositories.CertificationRepository;

@Service
public class CertificationService {
	
	@Autowired
	private CertificationRepository repo;
	
	// get all
	public Iterable<Certification> getAllCertifications() {
		return repo.findAll();
	}

}
