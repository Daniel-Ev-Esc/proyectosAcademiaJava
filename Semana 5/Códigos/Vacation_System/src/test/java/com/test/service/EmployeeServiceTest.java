package com.test.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.em.entities.Employee;
import com.em.repository.EmployeeRepository;
import com.em.service.EmployeeService;
import com.em.service.EmployeeServiceImpl;

// EmployeeServiceTest.java
// 10/09/2024
// Test the business logic of the app

class EmployeeServiceTest {
	
	// Mocks the repository functions
	@Mock
	EmployeeRepository repo;
	
	EmployeeService s;
	
	// Simulates data on the database
	List<Employee> employeeList = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		repo = mock(EmployeeRepository.class);
		s = new EmployeeServiceImpl(repo);
		
		employeeList.add(new Employee(1, "John", "Doe", "Engineering", "john.doe@example.com"));
		employeeList.add(new Employee(2, "Jane", "Smith", "Marketing", "jane.smith@example.com"));
		employeeList.add(new Employee(3, "Bob", "Johnson", "Sales", "bob.johnson@example.com"));
		employeeList.add(new Employee(4, "Alice", "Williams", "HR", "alice.williams@example.com"));
		employeeList.add(new Employee(5, "Charlie", "Brown", "Finance", "charlie.brown@example.com"));
		employeeList.add(new Employee(6, "Diana", "Moore", "IT", "diana.moore@example.com"));
		employeeList.add(new Employee(7, "Ethan", "Taylor", "Legal", "ethan.taylor@example.com"));
		employeeList.add(new Employee(8, "Fiona", "Anderson", "Operations", "fiona.anderson@example.com"));
		employeeList.add(new Employee(9, "George", "Thomas", "Customer Support", "george.thomas@example.com"));
		employeeList.add(new Employee(10, "Hannah", "Jackson", "Design", "hannah.jackson@example.com"));

	}

	// Gets the list of all Employees
	@Test
	void findAllTest() {
		
		// The repository should return the full list
		when(repo.findAll()).thenReturn(employeeList);
		
		// The service returns the list without changes
		List<Employee> result = s.getAll();
		
        assertEquals(employeeList, result);
        
        verify(repo).findAll();

	}
	
	// Gets a specific employee by id
	@Test
	void findByIdTest() {
		
		// The repository gets an optional if the element exists
		when(repo.findById(1)).thenReturn(Optional.of(employeeList.get(1)));
		
		// The service gets the value of the optional
		Employee result = s.findById(1);
		
        assertEquals(employeeList.get(1), result);
        
        verify(repo).findById(1);

	}
	
	// Tests the correct error message when element doesn't exist
	@Test
	void findByIdNullTest() {
		
		// The repository gets an optional that indicates the element doesn't exist
		when(repo.findById(11)).thenReturn(Optional.empty());
		
		// Assert that the service method throws an exception when an employee is not found
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            s.findById(11);
        });

        // Verify that the exception message is as expected
        assertEquals("Did not find employee id - 11", thrown.getMessage());

        verify(repo).findById(11);

	}
	
	// Tests the updating and creating of an element by the service
	@Test
	void saveEmployeeTest() {
		
		// The created object should return without changes
		when(repo.save(employeeList.get(1))).thenReturn(employeeList.get(1));
		
		Employee result = s.save(employeeList.get(1));
		
		assertEquals(employeeList.get(1), result);
        
        verify(repo).save(employeeList.get(1));
	}
	
	// Test that the repo method is called on delete
	@Test
	void deleteEmployeeTest() {
		
		s.deleteById(1);
		
		verify(repo, times(1)).deleteById(1);
		
	}

}
