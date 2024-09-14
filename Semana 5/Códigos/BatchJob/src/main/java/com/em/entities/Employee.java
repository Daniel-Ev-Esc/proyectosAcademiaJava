package com.em.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Employees_table")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId")
	private int id;
	@Column(name = "employeeName")
	private String name;
	@Column(name = "employeeLastName")
	private String lastName;
	@Column(name = "employeeDepartment")
	private String department;
	@Column(name = "employeeEmail")
	String email;
	
}
