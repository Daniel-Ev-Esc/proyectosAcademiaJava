package com.curso.v0;

public abstract class Observer {

	Observer(Subject sub){
		sub.attach(this);
	}
	
	abstract void update();
}
