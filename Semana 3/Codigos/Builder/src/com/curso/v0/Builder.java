package com.curso.v0;

// Builder interface, sets the methods needed to build an object
public interface Builder {
	Builder reset();
	Builder setLanguage(String language);
	Builder setTitle(String title);
	Builder setModules(int modules);
}
