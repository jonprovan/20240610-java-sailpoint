package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Department;

// a repository is an interface that contains all the database methods we need for basic CRUD operations
// we can write custom ones if we wish but don't have to if the default functionality is enough

// the @Repository annotation sets this up as a Bean that can be injected
// extending CrudRepository for basic functionality <Object Type, Primary Key Type>
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
	
	// we can put custom methods in here
	
	// ordering our results by id instead of name
	@Query(value = "SELECT * FROM department ORDER BY department_id", nativeQuery = true)  // nativeQuery lets us use familiar SQL
	public Iterable<Department> getAllDepartmentsOrderedById();
	
	// getting a count of the departments
	@Query(value = "SELECT COUNT(*) FROM department", nativeQuery = true)
	public int countDepartments();

}
