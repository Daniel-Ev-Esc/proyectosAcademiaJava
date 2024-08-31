package com.curso.v0;

import java.util.HashMap;

// Concrete component that represents an Account with a simple password
public class Account implements Component {
	
	private String username;
	private String password;

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// The getAccess method only allows access if the credentials match
	@Override
	public boolean getAccess(HashMap<String, String> accessTokens) {
		return this.username == accessTokens.get("Username") && this.password == accessTokens.get("Password");
	}

}
