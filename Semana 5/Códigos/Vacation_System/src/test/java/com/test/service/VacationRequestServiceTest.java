package com.test.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.em.dto.VacationRequestDTO;
import com.em.entities.Employee;
import com.em.entities.HREmployee;
import com.em.entities.VacationRequest;
import com.em.enumerators.Status;
import com.em.repository.EmployeeRepository;
import com.em.repository.HREmployeeRepository;
import com.em.repository.VacationRequestRepository;
import com.em.service.VacationRequestService;
import com.em.service.VacationRequestServiceImpl;

class VacationRequestServiceTest {

	// Mocks the repository functions
	@Mock
	EmployeeRepository repoEmployees;
	
	@Mock
	VacationRequestRepository repoVR;
	
	@Mock
	HREmployeeRepository repoHR;
	
	VacationRequestService s;
	
	Employee e;
	
	HREmployee hr;
	
	@BeforeEach
	public void setup() {
		repoHR = mock(HREmployeeRepository.class);
		repoEmployees = mock(EmployeeRepository.class);
		repoVR= mock(VacationRequestRepository.class);
		s = new VacationRequestServiceImpl(repoEmployees, repoVR, repoHR);
		e = new Employee(1, "John", "Doe", "Engineering", "john.doe@example.com");
		hr = new HREmployee(1, "Julio", "Martinez", "jmar@gmail.com");
	}
		
	@Test
	void createRequestTest() {
		when(repoEmployees.findById(1)).thenReturn(Optional.of(e));
		VacationRequest vr = new VacationRequest(e, LocalDate.of(2024, 9, 11), LocalDate.of(2024, 10, 11), Status.PENDING, "Familiar");
		when(repoVR.save(vr)).thenReturn(vr);
		
		VacationRequestDTO vrDTO = new VacationRequestDTO(e.getId(), LocalDate.of(2024, 9, 11), LocalDate.of(2024, 10, 11), Status.PENDING, "Familiar");
		
		VacationRequest result = s.makeRequest(vrDTO.getEmployeeId(), vrDTO.getStartDate(), vrDTO.getEndDate(), vrDTO.getStatus(), vrDTO.getReason());
		
		assertEquals(vr, result);
		
		verify(repoEmployees).findById(1);
		verify(repoVR).save(vr);
	}
	
	@Test
	void assignRequestTest() {
		when(repoHR.findById(1)).thenReturn(Optional.of(hr));
		VacationRequest vr = new VacationRequest(e, LocalDate.of(2024, 9, 11), LocalDate.of(2024, 10, 11), Status.PENDING, "Familiar");
		when(repoVR.findById(1)).thenReturn(Optional.of(vr));
		vr.setHrEmployee(hr);
		when(repoVR.save(vr)).thenReturn(vr);
		
		VacationRequest result = s.assignRequest(1, 1);
		
		assertEquals(vr, result);

		verify(repoHR).findById(1);
		verify(repoVR).save(vr);
	}
	
	@Test
	void acceptRequestTest() {
		VacationRequest vr = new VacationRequest(e, LocalDate.of(2024, 9, 11), LocalDate.of(2024, 10, 11), Status.PENDING, "Familiar");
		when(repoVR.findById(1)).thenReturn(Optional.of(vr));
		vr.setStatus(Status.ACCEPTED);
		when(repoVR.save(vr)).thenReturn(vr);
		
		VacationRequest result = s.acceptRequest(1);
		
		assertEquals(vr, result);
		
		verify(repoVR).save(vr);
	}
	
	@Test
	void rejectRequestTest() {
		VacationRequest vr = new VacationRequest(e, LocalDate.of(2024, 9, 11), LocalDate.of(2024, 10, 11), Status.PENDING, "Familiar");
		when(repoVR.findById(1)).thenReturn(Optional.of(vr));
		vr.setStatus(Status.DECLINED);
		when(repoVR.save(vr)).thenReturn(vr);
		
		VacationRequest result = s.rejectRequest(1);
		
		assertEquals(vr, result);
		
		verify(repoVR).save(vr);
	}

}
