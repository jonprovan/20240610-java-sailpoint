package com.skillstorm.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	@JsonIgnoreProperties("employees")
	private Department department;
	
//	@Column(name = "department_id")
//	private int departmentId;
	
	@Column(name = "employee_age")
	private double employeeAge;
	
//	@Column(name = "employee_name")
//	private String employeeName;
	
	@OneToOne
	@JoinColumn(name = "employee_detail", referencedColumnName = "detail_id")
	@JsonIgnoreProperties("employee")
	private Detail detail;
	
	// if we don't want to see the detail info in our results
//	@Column(name = "employee_detail")
//	private int employeeDetail;
	
	@ManyToMany
	@JoinTable(name = "employee_certification",									// what's the name of the join table
			   joinColumns = @JoinColumn(name = "employee_id"),					// which column in this table links to the join table
			   inverseJoinColumns = @JoinColumn(name = "certification_id"))		// which column in the other table links to the join table
	@JsonIgnoreProperties("employees")
	private List<Certification> certifications;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeFirstname, String employeeLastname, Department department,
			double employeeAge, Detail detail, List<Certification> certifications) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstname = employeeFirstname;
		this.employeeLastname = employeeLastname;
		this.department = department;
		this.employeeAge = employeeAge;
		this.detail = detail;
		this.certifications = certifications;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public double getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(double employeeAge) {
		this.employeeAge = employeeAge;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}
}
