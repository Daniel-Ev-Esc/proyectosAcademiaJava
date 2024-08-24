package com.curso.v0;


public class DebtClasification{
	
	private String name;
	private String clasification;
	
	public DebtClasification(String name, String clasification) {
		this.name = name;
		this.clasification = clasification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasification() {
		return clasification;
	}

	public void setClasification(String clasification) {
		this.clasification = clasification;
	}

	@Override
	public String toString() {
		return "DebtClasification [name=" + name + ", clasification=" + clasification + "]";
	}
	
}
