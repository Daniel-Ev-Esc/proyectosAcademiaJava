package com.curso.v0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuilderTest {

	@Test
	void shortCourseTest() {
		
		ShortCourseBuilder sCourseBuilder = new ShortCourseBuilder(new ShortCourse());
		
		Director director = new Director();
		
		director.makeJavaCourse(sCourseBuilder, "Introduction to Java", 5);
		
		ShortCourse sCourse = sCourseBuilder.getResult();
		
		assertEquals("Java", sCourse.getLanguage());
		assertEquals("Introduction to Java", sCourse.getTitle());
		assertEquals(5, sCourse.getModules());
	}
	
	@Test
	void longCourseTest() {
		
		LongCourseBuilder lCourseBuilder = new LongCourseBuilder(new LongCourse());
		
		Director director = new Director();
		
		director.makePythonCourse(lCourseBuilder, "Advanced Java", 15);
		
		LongCourse lCourse = lCourseBuilder.getResult();
		
		assertEquals("Python", lCourse.getLanguage());
		assertEquals("Advanced Java", lCourse.getTitle());
		assertEquals(15, lCourse.getModules());
	}

}
