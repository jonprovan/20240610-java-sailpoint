package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Department;
import com.skillstorm.models.Employee;
import com.skillstorm.repositories.DepartmentRepository;

@Service							// designates this as an injectable service for request logic/handling
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repo;
	
	// get all
	public Iterable<Department> getAllDepartments() {
		return repo.getAllDepartmentsOrderedById();
	}
	
	// get one by id
	public Department getDepartmentById(int id) {
		if (!repo.existsById(id))					// Guard Clause! (Thank you, Yuri!)
			return null;
		return repo.findById(id).get();				// this throws an exception if it doesn't exist, but we've already checked for that
	}
	
	// create one
	public Department createDepartment(Department department) {
		if (repo.existsById(department.getDepartmentId()))
			return null;
		return repo.save(department);
	}
	
	// update one
	public Department updateDepartment(int id, String name, List<Employee> employees) {
		if (!repo.existsById(id))
			return null;
		return repo.save(new Department(id, name, employees));
	}
	
	// delete one
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	// get total number of departments
	public int getCountOfDepartments() {
		return repo.countDepartments();
	}
	
}
