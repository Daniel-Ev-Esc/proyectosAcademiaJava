package com.curso.v0;

import java.util.HashMap;

public class SecurityQuestionAccount extends Decorator {

	private String question;
	private String answer;

	public SecurityQuestionAccount(Component component, String question, String answer) {
		super(component);
		this.question = question;
		this.answer = answer;
	}
	
	void getHint() {
		System.out.println(question);
	}

	@Override
	public boolean getAccess(HashMap<String, String> accessTokens) {
		return getComponent().getAccess(accessTokens) && answer == accessTokens.get("Security question");
	}
	
}
