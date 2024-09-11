package com.test.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.em.entities.HREmployee;

class HREmployee_Test {

	@Test
	void attributesTest() {
		HREmployee e = new HREmployee(2,"Daniel Evaristo", "Escalera Bonilla", "HR","daniele080203@gmail.com");
		
		assertEquals(2, e.getId());
		assertEquals("Daniel Evaristo", e.getName());
		assertEquals("Escalera Bonilla", e.getLastName());
		assertEquals("HR", e.getDepartment());
		assertEquals("daniele080203@gmail.com", e.getEmail());
	}

}
