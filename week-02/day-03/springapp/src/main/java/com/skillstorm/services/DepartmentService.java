package com.skillstorm.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Department;
import com.skillstorm.models.Employee;
import com.skillstorm.repositories.DepartmentRepository;

@Service							// designates this as an injectable service for request logic/handling
public class DepartmentService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DepartmentRepository repo;
	
	// get all
	public Iterable<Department> getAllDepartments() {
		return repo.getAllDepartmentsOrderedById();
	}
	
//	// get one by id
//	public Department getDepartmentById(int id) {
//		if (!repo.existsById(id))					// Guard Clause! (Thank you, Yuri!)
//			return null;
//		return repo.findById(id).get();				// this throws an exception if it doesn't exist, but we've already checked for that
//	}
	
	public ResponseEntity<Department> getDepartmentById(int id) {
		if (!repo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .header("Error", "A Department with this ID doesn't exist!")
								 .header("Instructions", "Do better next time...")
								 .body(null);
		}
		// return a successful response
		return ResponseEntity.status(HttpStatus.OK)
							 .header("Message", "We successfully got a Department by ID!")
							 .body(repo.findById(id).get());
		
	}
	
	
//	// create one
//	public Department createDepartment(Department department) {
//		if (repo.existsById(department.getDepartmentId()))
//			return null;
//		return repo.save(department);
//	}
	
	public ResponseEntity<Department> createDepartment(Department department) {
		if (repo.existsById(department.getDepartmentId())) {
			
			logger.error("Tried to create a Department that already exists!");
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .header("Error", "A Department with this ID already exists.")
								 .body(department);
		}
		
		// you can create a headers object to include many headers at once in your response
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Department was created.");
		headers.add("Mood", "Upbeat");
		headers.add("Prognosis", "Great success ahead.");
		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .headers(headers)
							 .body(repo.save(department));
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
