package com.curso.v0;

public class ShortCourseBuilder implements Builder{
	
	// Instance of object to build
	private ShortCourse shortCourse;
	
	public ShortCourseBuilder(ShortCourse shortCourse) {
		this.shortCourse = shortCourse;
	}
	
	// Set properties to initial values
	@Override
	public Builder reset() {
		this.shortCourse = new ShortCourse();
		return this;
	}

	@Override
	public Builder setLanguage(String language) {
		shortCourse.setLanguage(language);
		return this;
	}
	
	@Override
	public Builder setTitle(String title) {
		shortCourse.setTitle(title);
		return this;
	}
	
	@Override
	public Builder setModules(int modules) {
		shortCourse.setModules(modules);
		return this;
	}
	
	// Return instance of object with values specified by methods
	public ShortCourse getResult() {
		return shortCourse;
	}
	
}
