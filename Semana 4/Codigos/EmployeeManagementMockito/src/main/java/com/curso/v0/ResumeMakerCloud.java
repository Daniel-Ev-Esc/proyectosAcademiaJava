package com.curso.v0;

import java.util.Date;

public interface ResumeMakerCloud {
	
	String makeIdentifier(String name, String lastName, String birthDate);
	
	boolean addSkill(String identifier, String skill);
}
