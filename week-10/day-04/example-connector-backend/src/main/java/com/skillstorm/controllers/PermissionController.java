package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Permission;
import com.skillstorm.services.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService service;
	
	@GetMapping
	public Iterable<Permission> getAllPermissions() {
		return service.getAllPermissions();
	}

}
