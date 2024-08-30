package com.curso.v0;

//                              IS-A
public abstract class Decorator implements Component {
	
	//  HAS A
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
