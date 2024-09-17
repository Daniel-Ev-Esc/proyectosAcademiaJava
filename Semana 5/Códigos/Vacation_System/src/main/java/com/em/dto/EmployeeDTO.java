package com.em.dto;


public class EmployeeDTO {

	private String name;
	private String lastName;
	private String department;
	private String email;
    private String pass;
    
	public EmployeeDTO(String name, String lastName, String department, String email, String pass) {
		this.name = name;
		this.lastName = lastName;
		this.department = department;
		this.email = email;
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDepartment() {
		return department;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
    
    
}
