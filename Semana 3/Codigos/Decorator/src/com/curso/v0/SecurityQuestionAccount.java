package com.curso.v0;

import java.util.HashMap;

// Decorator additional to the internal components access, asks for the answer to a security question
public class SecurityQuestionAccount extends Decorator {

	private String question;
	private String answer;

	public SecurityQuestionAccount(Component component, String question, String answer) {
		super(component);
		this.question = question;
		this.answer = answer;
	}
	
	// Displays the question that requires the answer
	void getHint() {
		System.out.println(question);
	}

	// Activates the get access fot the internal components which allows it to search for all credentials
	@Override
	public boolean getAccess(HashMap<String, String> accessTokens) {
		return getComponent().getAccess(accessTokens) && answer == accessTokens.get("Security question");
	}
	
}
