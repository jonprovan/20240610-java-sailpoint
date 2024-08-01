package com.skillstorm.dtos;

public class RegisterUserDto {
    private String email;
    
    private String password;
    
    private String fullName;
    
    public RegisterUserDto() {
    	super();
    }

	public RegisterUserDto(String email, String password, String fullName) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
    
}
