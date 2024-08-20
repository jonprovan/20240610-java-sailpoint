package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Permission;
import com.skillstorm.repositories.PermissionRepository;

@Service
public class PermissionService {
	
	@Autowired
	private PermissionRepository repo;
	
	public Iterable<Permission> getAllPermissions() {
		return repo.findAll();
	}

}
