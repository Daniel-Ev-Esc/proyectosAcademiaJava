package com.curso.v0;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class DecoratorTest {

	// Access an account with simple password
	@Test
	void simpleAccessTest() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountAccess = new Account("Daniel080203","contra123");

		accessTokens.put("Username", "Daniel080203");
		accessTokens.put("Password", "contra123");
		
		assertEquals(true, accountAccess.getAccess(accessTokens));
	}
	
	// Access an account with two-factor authentication
	@Test
	void twoFactorAccessTest() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();

		Component accountTwoFactorAccess = new TwoFactorAccount(new Account("Daniel080203","contra123"), "79");
		
		accessTokens.put("Username", "Daniel080203");
		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "79");
				
		assertEquals(true, accountTwoFactorAccess.getAccess(accessTokens));
	}
	
	// Access an account with all security measures (SecurityQuestion added last)
	@Test
	void maxSecurityAccessTest1() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();

		Component accountMaxSecurity = new SecurityQuestionAccount( new TwoFactorAccount(new Account("Daniel080203","contra123"), "79"), "¿Cuál es el nombre de tu perro?", "Firulais");
		
		accessTokens.put("Username", "Daniel080203");
		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "79");
		accessTokens.put("Security question", "Firulais");
		
		assertEquals(true, accountMaxSecurity.getAccess(accessTokens));
	}
	
	// Access an account with all security measures (2FA added last)
	@Test
	void maxSecurityAccessTest2() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountMaxSecurity = new TwoFactorAccount( new SecurityQuestionAccount(new Account("Daniel080203","contra123"), "¿Cuál es el nombre de tu perro?", "Firulais"), "79");

		accessTokens.put("Username", "Daniel080203");
		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "79");
		accessTokens.put("Security question", "Firulais");
		
		assertEquals(true, accountMaxSecurity.getAccess(accessTokens));
	}

	// Access an account with security question
	@Test
	void securityQuestionTest() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		SecurityQuestionAccount accountQuestion = new SecurityQuestionAccount(new Account("Daniel080203", "contra123"), "¿Cuál es el nombre de tu perro?", "Firulais");

		accountQuestion.getHint();
		
		accessTokens.put("Username", "Daniel080203");
		accessTokens.put("Password", "contra123");
		accessTokens.put("Security question", "Firulais");
		
		assertEquals(true, accountQuestion.getAccess(accessTokens));
	}
	
	// Cant access the acount with wrong 2FA code
	@Test
	void maxSecurityAccessFailTest1() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountMaxSecurity = new TwoFactorAccount( new SecurityQuestionAccount(new Account("Daniel080203", "contra123"), "¿Cuál es el nombre de tu perro?", "Firulais"), "79");

		accessTokens.put("Username", "Daniel080203");
		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "78");
		accessTokens.put("Security question", "Firulais");
		
		
		assertEquals(false, accountMaxSecurity.getAccess(accessTokens));
	}
	
	// Cant access the account with wrong password
	@Test
	void maxSecurityAccessFailTest2() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountMaxSecurity = new TwoFactorAccount( new SecurityQuestionAccount(new Account("Daniel080203", "contra123"), "¿Cuál es el nombre de tu perro?", "Firulais"), "79");

		accessTokens.put("Username", "Daniel080203");
		accessTokens.put("Password", "contra12");
		accessTokens.put("2FAcode", "79");
		accessTokens.put("Security question", "Firulais");
		
		
		assertEquals(false, accountMaxSecurity.getAccess(accessTokens));
	}
	
	// Cant access the acount with wrong answer
	@Test
	void maxSecurityAccessFailTest3() {
		
		HashMap<String, String> accessTokens = new HashMap<String, String>();
		
		Component accountMaxSecurity = new TwoFactorAccount( new SecurityQuestionAccount(new Account("Daniel080203", "contra123"), "¿Cuál es el nombre de tu perro?", "Firulais"), "79");

		accessTokens.put("Password", "contra123");
		accessTokens.put("2FAcode", "79");
		accessTokens.put("Security question", "Firlais");
		
		
		assertEquals(false, accountMaxSecurity.getAccess(accessTokens));
	}
	
}
