package com.test.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.em.dto.VacationRequestDTO;
import com.em.entities.CustomMessage;
import com.em.entities.Employee;
import com.em.entities.HREmployee;
import com.em.entities.VacationRequest;
import com.em.enumerators.Status;
import com.em.repository.EmployeeRepository;
import com.em.repository.HREmployeeRepository;
import com.em.repository.MessageRepository;
import com.em.repository.VacationRequestRepository;
import com.em.service.MessageService;
import com.em.service.MessageServiceImpl;
import com.em.service.VacationRequestService;
import com.em.service.VacationRequestServiceImpl;

class MessageServiceTest {

	// Mocks the repository functions
	@Mock
	MessageRepository repoMessage;
	
	MessageService s;
	
	List<CustomMessage> cmList = new ArrayList<CustomMessage>();
	
	@BeforeEach
	public void setup() {
		repoMessage = mock(MessageRepository.class);
		s = new MessageServiceImpl(repoMessage);
		
		cmList.add(new CustomMessage("id0","helloWorld",false,new Date(2024,8,2)));
	}
		
	@Test
	void getMessages() {
		when(repoMessage.findAll()).thenReturn(cmList);
		
		List<CustomMessage> result = s.getAll();
		
		assertEquals(result, cmList);
		
		verify(repoMessage).findAll();
	}
	
	@Test
	void dismissTest() {
		CustomMessage cm = cmList.get(0);
		when(repoMessage.findById("id0")).thenReturn(Optional.of(cm));
		cm.setDismissed(true);
		when(repoMessage.save(cm)).thenReturn(cm);
		
		CustomMessage result = s.dismiss("id0");
		
		assertEquals(cm, result);
		
		verify(repoMessage).save(cm);
	}

}
