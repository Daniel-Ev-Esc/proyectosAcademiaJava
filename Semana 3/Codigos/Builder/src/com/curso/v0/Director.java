package com.curso.v0;

public class Director {

	public void makeJavaCourse(Builder builder, String title, int modules) {
		builder.setTitle(title).setLanguage("Java").setModules(modules);
	}

	public void makePythonCourse(Builder builder, String title, int modules) {
		builder.setTitle(title).setLanguage("Python").setModules(modules);		
	}

}
