package com.curso.v0;

// Decorator
public abstract class Decorator implements Component {
	
	//Contains a component to activate it's get access method
	private Component component;
	
	public Decorator(Component component) {
		this.setComponent(component);
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
	
}
