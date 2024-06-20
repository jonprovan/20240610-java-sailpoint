package com.skillstorm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detail")
public class Detail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detail_id")
	private int detailId;
	
	@Column(name = "detail_text")
	private String detailText;
	
	// this property DOES NOT EXIST in this table, but it's okay to have it in our object
	@OneToOne(mappedBy = "detail")
	@JsonIgnoreProperties("detail")
	private Employee employee;
	
	public Detail() {
		super();
	}

	public Detail(int detailId, String detailText, Employee employee) {
		super();
		this.detailId = detailId;
		this.detailText = detailText;
		this.employee = employee;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public String getDetailText() {
		return detailText;
	}

	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
