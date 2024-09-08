package com.curso.v0;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class ResumeMakerTest {
	
	@Mock
	ResumeMakerCloud rmc;
	
	ResumeMaker rm;
	
	@BeforeEach
	public void setUp() {
		rmc = mock(ResumeMakerCloud.class);
		rm = new ResumeMaker(rmc);
	}

	@Test
	void makeIdentifierTest() {
		when(rmc.makeIdentifier("Daniel Evaristo", "Escalera Bonilla", "2004-02-08")).thenReturn("DEEB080203");

		String result = rm.makeIdentifier("Daniel Evaristo", "Escalera Bonilla", "2004-02-08");
		
		assertEquals("DEEB080203", result);
		
		verify(rmc).makeIdentifier("Daniel Evaristo", "Escalera Bonilla", "2004-02-08");
		
	}
	
	@Test
	void addSkill() {
		when(rmc.addSkill("FE001","Angular")).thenReturn(true);

		boolean result = rm.addSkill("FE001","Angular");
		
		assertEquals(true, result);
		
		verify(rmc).addSkill("FE001","Angular");
		
	}

}
