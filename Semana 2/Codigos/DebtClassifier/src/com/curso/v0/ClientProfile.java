package com.curso.v0;

public class ClientProfile {
	private String name;
	private int debt;
	private	double generatedInterest;
	private int faildeMonths;
	
	public ClientProfile(String name, int debt, double generatedInterest, int faildeMonths) {
		this.name = name;
		this.debt = debt;
		this.generatedInterest = generatedInterest;
		this.faildeMonths = faildeMonths;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	public double getGeneratedInterest() {
		return generatedInterest;
	}

	public void setGeneratedInterest(double generatedInterest) {
		this.generatedInterest = generatedInterest;
	}

	public int getFaildeMonths() {
		return faildeMonths;
	}

	public void setFaildeMonths(int faildeMonths) {
		this.faildeMonths = faildeMonths;
	}

	@Override
	public String toString() {
		return "ClientProfile [name=" + name + ", debt=" + debt + ", generatedInterest=" + generatedInterest
				+ ", faildeMonths=" + faildeMonths + "]";
	}

}
