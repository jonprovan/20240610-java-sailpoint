package com.skillstorm.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// MODEL-VIEW-CONTROLLER (MVC)
/*
 * Model = the current representation of the data in the request
 * View = the actual data being "seen", in this case, sent to the frontend
 * Controller = any functionality that adjusts or manipulates that data
 */

// this class is a model for a database record in the department table
// one instance of this class = one database record

@Entity							// specifies that this class is representative of a DB entity
@Table(name = "department")		// specifies which table these are coming from
public class Department {
	
	@Id														// specifies this as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// says that the DB must generate the value for this field
	@Column(name = "department_id")							// specifies which column in the DB this field goes with
	private int departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("department")
	private List<Employee> employees;
	
	// we do need a no-args constructor, or Spring will throw errors later
	public Department() {
		super();
	}

	// can generate from here on down with Source, if you like
	public Department(int departmentId, String departmentName, List<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
