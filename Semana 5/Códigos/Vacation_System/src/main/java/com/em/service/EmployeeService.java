package com.em.service;

import java.util.List;

import com.em.entities.Employee;

public interface EmployeeService {

	List<Employee> getAll();

	Employee findById(int i);

	Employee save(Employee employee);

	void deleteById(int i);

}
