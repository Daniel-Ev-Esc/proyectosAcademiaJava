package com.curso.v0;

import java.util.HashMap;

// Decorator that simulates two-factor authentication
public class TwoFactorAccount extends Decorator {
	
	// A set code is established on the constructor
	private String code;

	public TwoFactorAccount(Component component, String code) {
		super(component);
		this.code = code;
	}

	// Calls to get access in the internal component and checks the two-factor authentication code in addition
	@Override
	public boolean getAccess(HashMap<String, String> accessTokens) {
		return getComponent().getAccess(accessTokens) && code == accessTokens.get("2FAcode");
	}

}
