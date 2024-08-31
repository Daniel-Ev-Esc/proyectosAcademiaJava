package com.curso.v0;

public class LongCourseBuilder implements Builder{

	// Instance of object to build
	private LongCourse longCourse;
	
	public LongCourseBuilder(LongCourse longCourse) {
		this.longCourse = longCourse;
	}
	
	// Set properties to initial values
	@Override
	public Builder reset() {
		this.longCourse = new LongCourse();
		return this;
	}

	@Override
	public Builder setLanguage(String language) {
		longCourse.setLanguage(language);
		return this;
	}
	
	@Override
	public Builder setTitle(String title) {
		longCourse.setTitle(title);
		return this;
	}
	
	@Override
	public Builder setModules(int modules) {
		longCourse.setModules(modules);
		return this;
	}
	
	// Return instance of object with values specified by methods
	public LongCourse getResult() {
		return longCourse;
	}
	
}
