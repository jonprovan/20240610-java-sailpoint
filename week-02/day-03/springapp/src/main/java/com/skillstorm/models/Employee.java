package com.skillstorm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "employee_firstname")
	private String employeeFirstname;
	
	@Column(name = "employee_lastname")
	private String employeeLastname;
	
	@Column(name = "department_id")
	private int departmentId;
	
	@Column(name = "employee_age")
	private double employeeAge;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_detail", referencedColumnName = "detail_id")
	@JsonIgnoreProperties("employee")
	private Detail detail;
	
	// if we don't want to see the detail info in our results
//	@Column(name = "employee_detail")
//	private int employeeDetail;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeFirstname, String employeeLastname, int departmentId,
			double employeeAge, String employeeName, Detail detail) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstname = employeeFirstname;
		this.employeeLastname = employeeLastname;
		this.departmentId = departmentId;
		this.employeeAge = employeeAge;
		this.employeeName = employeeName;
		this.detail = detail;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstname() {
		return employeeFirstname;
	}

	public void setEmployeeFirstname(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}

	public String getEmployeeLastname() {
		return employeeLastname;
	}

	public void setEmployeeLastname(String employeeLastname) {
		this.employeeLastname = employeeLastname;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public double getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(double employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}
}
