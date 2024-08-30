package com.curso.v0;

import java.util.HashMap;

public class Account implements Component {
	
	private String password;

	public Account(String password) {
		this.password = password;
	}

	@Override
	public boolean getAccess(HashMap<String, String> accessTokens) {
		return this.password == accessTokens.get("Password");
	}

}
