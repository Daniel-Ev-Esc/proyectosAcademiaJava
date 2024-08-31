package com.curso.v0;

import java.util.ArrayList;
import java.util.List;

// A subject has a subscriber Array in which it iterates to update in case of changes
public abstract class Subject {

	List<Observer> observers = new ArrayList<>();
	
	void attach(Observer o) {
		observers.add(o);
	}
	
	void detach(Observer o) {
		observers.removeIf(x -> x.equals(o));
	}
	
	void notificar() {
		for(Observer o:observers)
			o.update();
	}

}

