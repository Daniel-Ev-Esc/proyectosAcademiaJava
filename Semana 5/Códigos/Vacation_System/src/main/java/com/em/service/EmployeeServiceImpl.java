package com.em.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.entities.Employee;
import com.em.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
				
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
	
	@Override
	public Employee findByEmail(String string) {
		return employeeRepository.findByEmail(string);
	}
}
