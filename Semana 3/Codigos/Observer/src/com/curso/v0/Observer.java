package com.curso.v0;

// Abstract class of an observer which can subscribe to a subject list and recieve updates
public abstract class Observer {

	Observer(Subject sub){
		sub.attach(this);
	}
	
	abstract void update();
	
	
}
