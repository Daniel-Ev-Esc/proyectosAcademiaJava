package com.em.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "HREmployees_table")
public class HREmployee{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId")
	private int id;
	@Column(name = "employeeName")
	private String name;
	@Column(name = "employeeLastName")
	private String lastName;
	@Column(name = "employeeDepartment")
	private String department = "HR";
	@Column(name = "employeeEmail")
	String email;
	
	public HREmployee(int id, String name, String lastName, String email) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.department = "HR";
	}
	
	
}
