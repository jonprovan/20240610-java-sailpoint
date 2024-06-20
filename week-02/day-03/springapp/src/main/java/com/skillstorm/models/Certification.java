package com.skillstorm.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "certification")
public class Certification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "certification_id")
	private int certificationId;
	
	@Column(name = "certification_name")
	private String certificationName;
	
	@ManyToMany(mappedBy = "certifications")
	@JsonIgnoreProperties("certifications")
	private List<Employee> employees;
	
	public Certification() {
		super();
	}

	public Certification(int certificationId, String certificationName, List<Employee> employees) {
		super();
		this.certificationId = certificationId;
		this.certificationName = certificationName;
		this.employees = employees;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
