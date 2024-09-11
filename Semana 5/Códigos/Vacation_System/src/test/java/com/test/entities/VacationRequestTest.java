package com.test.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.em.entities.Employee;
import com.em.entities.VacationRequest;
import com.em.enumerators.Status;

class VacationRequestTest {

	@Test
	void attributesTest() {
		VacationRequest vr = new VacationRequest(new Employee(1, "John", "Doe", "Engineering", "john.doe@example.com"), LocalDate.of(2024,9,10), LocalDate.of(2024,10,10), Status.PENDING,"PTO");
		
		assertEquals(new Employee(1, "John", "Doe", "Engineering", "john.doe@example.com"), vr.getRequester());
		assertEquals(LocalDate.of(2024,9,10), vr.getStartDate());
		assertEquals(LocalDate.of(2024, 10, 10), vr.getEndDate());
		assertEquals(Status.PENDING, vr.getStatus());
		assertEquals("PTO", vr.getReason());
		
	}

}
