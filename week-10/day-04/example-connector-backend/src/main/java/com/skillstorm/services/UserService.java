package com.skillstorm.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Permission;
import com.skillstorm.models.User;
import com.skillstorm.repositories.PermissionRepository;
import com.skillstorm.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PermissionRepository permissionRepo;
	
	// get all
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	// get by ID
	public User getById(int id) {
		return userRepo.findById(id).get();
	}
	
	// create one
	public User createUser(User user) {
		user.setId(0);
		return userRepo.save(user);
	}
	
	// update one
	public User updateUser(Map<String, Object> body) {
		User temp = userRepo.findByUsername(body.get("username").toString());
		if (body.get("id") != null)
			temp.setId((int)body.get("id"));
		if (body.get("username") != null)
			temp.setUsername((String)body.get("username"));
		if (body.get("firstname") != null)
			temp.setFirstname((String)body.get("firstname"));
		if (body.get("lastname") != null)
			temp.setLastname((String)body.get("lastname"));
		if (body.get("department") != null)
			temp.setDepartment((String)body.get("department"));
		
		if (body.get("permission") != null) {
			List<Permission> newPermissions = new LinkedList<>();
			for (String permissionName : (List<String>)body.get("permission")) {
				newPermissions.add(permissionRepo.findByName(permissionName));
			}
			temp.setPermission(newPermissions);
		}
		
		return userRepo.save(temp);
	}

}
