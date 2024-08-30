package com.curso.v0;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class DecoratorTest {

	@Test
	void simpleAccessTest() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountAccess = new Account("contra123");

		accessTokens.put("Password", "contra123");
		
		assertEquals(true, accountAccess.getAccess(accessTokens));
	}
	
	@Test
	void twoFactorAccessTest() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();

		Component accountTwoFactorAccess = new TwoFactorAccount(new Account("contra123"), "79");
		
		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "79");
				
		
		assertEquals(true, accountTwoFactorAccess.getAccess(accessTokens));
	}
	
	@Test
	void maxSecurityAccessTest1() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();

		Component accountMaxSecurity = new SecurityQuestionAccount( new TwoFactorAccount(new Account("contra123"), "79"), "¿Cuál es el nombre de tu perro", "Firulais");
		
		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "79");
		accessTokens.put("Security question", "Firulais");
		
		
		assertEquals(true, accountMaxSecurity.getAccess(accessTokens));
	}
	
	@Test
	void maxSecurityAccessTest2() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountMaxSecurity = new TwoFactorAccount( new SecurityQuestionAccount(new Account("contra123"), "¿Cuál es el nombre de tu perro", "Firulais"), "79");

		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "79");
		accessTokens.put("Security question", "Firulais");
		
		
		assertEquals(true, accountMaxSecurity.getAccess(accessTokens));
	}

	@Test
	void securityQuestionTest() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		SecurityQuestionAccount accountQuestion = new SecurityQuestionAccount(new Account("contra123"), "¿Cuál es el nombre de tu perro", "Firulais");

		accountQuestion.getHint();
		
		accessTokens.put("Password", "contra123");
		accessTokens.put("Security question", "Firulais");
		
		assertEquals(true, accountQuestion.getAccess(accessTokens));
	}
	
	@Test
	void maxSecurityAccessFailTest1() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountMaxSecurity = new TwoFactorAccount( new SecurityQuestionAccount(new Account("contra123"), "¿Cuál es el nombre de tu perro", "Firulais"), "79");

		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "78");
		accessTokens.put("Security question", "Firulais");
		
		
		assertEquals(false, accountMaxSecurity.getAccess(accessTokens));
	}
	
	@Test
	void maxSecurityAccessFailTest2() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountMaxSecurity = new TwoFactorAccount( new SecurityQuestionAccount(new Account("contra123"), "¿Cuál es el nombre de tu perro", "Firulais"), "79");

		accessTokens.put("Password", "contra12");
		accessTokens.put("2FAcode", "79");
		accessTokens.put("Security question", "Firulais");
		
		
		assertEquals(false, accountMaxSecurity.getAccess(accessTokens));
	}
	
	@Test
	void maxSecurityAccessFailTest3() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountMaxSecurity = new TwoFactorAccount( new SecurityQuestionAccount(new Account("contra123"), "¿Cuál es el nombre de tu perro", "Firulais"), "79");

		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "79");
		accessTokens.put("Security question", "Firlais");
		
		
		assertEquals(false, accountMaxSecurity.getAccess(accessTokens));
	}
	
}
