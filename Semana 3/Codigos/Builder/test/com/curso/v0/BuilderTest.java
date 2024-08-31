package com.curso.v0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuilderTest {

	// Use of Director to create the first type of course
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
	
	// Use of Director to create the second type of course
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
	
	//Use of builder to create objects
	@Test
	void buildWithoutDirector() {
		LongCourseBuilder lCourseBuilder = new LongCourseBuilder(new LongCourse());
		
		lCourseBuilder.reset().setLanguage("C++").setTitle("C++ for bussiness").setModules(10);
		
		LongCourse cCourse = lCourseBuilder.getResult();

		lCourseBuilder.reset().setLanguage("Angular").setTitle("Angular basics");
		
		LongCourse aCourse = lCourseBuilder.getResult();
		
		assertEquals("C++", cCourse.getLanguage());
		assertEquals("C++ for bussiness", cCourse.getTitle());
		assertEquals(10, cCourse.getModules());
		
		assertEquals("Angular", aCourse.getLanguage());
		assertEquals("Angular basics", aCourse.getTitle());
	}

}
