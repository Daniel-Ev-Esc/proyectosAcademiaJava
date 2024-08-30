package com.curso.v0;

import java.util.HashMap;

public class TwoFactorAccount extends Decorator {
	
	private String code;

	public TwoFactorAccount(Component component, String code) {
		super(component);
		this.code = code;
	}

	@Override
	public boolean getAccess(HashMap<String, String> accessTokens) {
		return getComponent().getAccess(accessTokens) && code == accessTokens.get("2FAcode");
	}

}
