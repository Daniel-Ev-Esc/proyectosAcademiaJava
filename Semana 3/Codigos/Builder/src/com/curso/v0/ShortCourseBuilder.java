package com.curso.v0;

public class ShortCourseBuilder implements Builder{
	
	private ShortCourse shortCourse;
	
	public ShortCourseBuilder(ShortCourse shortCourse) {
		this.shortCourse = shortCourse;
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
	
	public ShortCourse getResult() {
		return shortCourse;
	}
	
}
