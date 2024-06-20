package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Department;
import com.skillstorm.models.Employee;
import com.skillstorm.repositories.DepartmentRepository;
import com.skillstorm.services.DepartmentService;

// a controller is a class that contains all the endpoints for a particular type of record
// anything we want to be able to do with this type needs to start here

@RestController							// combines @Controller and @ResponseBody
@RequestMapping("/department")			// all requests to baseUrl plus this suffix will route here
@CrossOrigin(origins = "*")				// from where am I allowed to make requests to this controller?
public class DepartmentController {
	
	// this automatically injects our service for use here
	// all instantiation and management is left to the IoC container
	@Autowired
	private DepartmentService service;
	
	// an endpoint for getting all departments
	// @GetMapping says this is a GET request
	// return type has to match what you're getting back (or what you change it to)
	@GetMapping
	public Iterable<Department> getAllDepartments() {
		return service.getAllDepartments();				// now kicking to our service for the actual logic of these requests, if any
	}
	
	@GetMapping("/{id}")											// can specify an additional suffix per method, curly braces indicate a path variable
	public Department getDepartmentById(@PathVariable int id) {		// have to specify that the id variable comes from the path
		return service.getDepartmentById(id);							
	}
	
	@PostMapping
	public Department addDepartment(@RequestBody Department department) {
		return service.createDepartment(department);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDepartmentById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PutMapping
	public Department updateDepartment(@RequestParam int id, @RequestParam String name, @RequestBody List<Employee> employees) {
		return service.updateDepartment(id, name, employees);
	}
	
	// an endpoint for getting our Department count
	@GetMapping("/count")
	public int getDepartmentCount() {
		return service.getCountOfDepartments();
	}
	
	
	
	
}
