package com.skillstorm.models;

// this class is a basic structure for our Office objects
// it does not need to be mapped to the database
// we have two constructors, one for objects going in (no need for an id), one for objects coming out
public class Office {
	
	private int id;
	private String department;
	private String address;
	
	public Office(String department, String address) {
		this.department = department;
		this.address = address;
	}
	
	public Office(int id, String department, String address) {
		this.id = id;
		this.department = department;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
