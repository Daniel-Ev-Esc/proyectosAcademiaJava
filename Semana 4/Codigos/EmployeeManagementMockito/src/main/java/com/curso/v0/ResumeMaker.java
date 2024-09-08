package com.curso.v0;

public class ResumeMaker {
	
	ResumeMakerCloud rmc;
	
	public ResumeMaker(ResumeMakerCloud rmc) {
		this.rmc = rmc;
	}

	String makeIdentifier(String name, String lastName, String birthDate) {
		return rmc.makeIdentifier(name, lastName, birthDate);
	};
	
	boolean addSkill(String identifier, String skill) {
		return rmc.addSkill(identifier, skill);
	};

}
