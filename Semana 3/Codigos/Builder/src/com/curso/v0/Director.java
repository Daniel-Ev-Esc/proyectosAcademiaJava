package com.curso.v0;

public class Director {

	// Creates a Java course with the specified properties
	public void makeJavaCourse(Builder builder, String title, int modules) {
		builder.reset().setTitle(title).setLanguage("Java").setModules(modules);
	}

	// Creates a Python course with the specified properties
	public void makePythonCourse(Builder builder, String title, int modules) {
		builder.reset().setTitle(title).setLanguage("Python").setModules(modules);		
	}

}
