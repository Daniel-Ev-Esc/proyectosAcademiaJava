package com.test.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.em.entities.Employee;

class Employee_Test {

	@Test
	void attributesTest() {
		Employee e = new Employee(1,"Daniel Evaristo", "Escalera Bonilla", "IT", "daniele080203@gmail.com");
		
		assertEquals(1, e.getId());
		assertEquals("Daniel Evaristo", e.getName());
		assertEquals("Escalera Bonilla", e.getLastName());
		assertEquals("IT", e.getDepartment());
		assertEquals("daniele080203@gmail.com", e.getEmail());

	}

}
