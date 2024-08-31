package com.curso.v0;

public class LongCourseBuilder implements Builder{

	private LongCourse longCourse;
	
	public LongCourseBuilder(LongCourse longCourse) {
		this.longCourse = longCourse;
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
	
	public LongCourse getResult() {
		return longCourse;
	}
	
}
