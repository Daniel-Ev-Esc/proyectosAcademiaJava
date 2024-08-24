package com.curso.v0;

public class Employee implements Comparable<Employee> {
	
	private String name;
	private int workHours;
	private boolean reportsFilled;
	private boolean trainingCompleted;
	private double salary;
	
	public Employee(String name, int workHours, boolean reportsFilled, boolean trainingCompleted, double salary) {
		this.name = name;
		this.workHours = workHours;
		this.reportsFilled = reportsFilled;
		this.trainingCompleted = trainingCompleted;
		this.salary = salary;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getWorkHours() {
		return workHours;
	}



	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}



	public boolean isReportsFilled() {
		return reportsFilled;
	}



	public void setReportsFilled(boolean reportsFilled) {
		this.reportsFilled = reportsFilled;
	}



	public boolean isTrainingCompleted() {
		return trainingCompleted;
	}



	public void setTrainingCompleted(boolean trainingCompleted) {
		this.trainingCompleted = trainingCompleted;
	}
	
	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee other) {
		return this.workHours - other.workHours;
	}



	@Override
	public String toString() {
		return "Employee [name=" + name + ", workHours=" + workHours + ", reportsFilled=" + reportsFilled
				+ ", trainingCompleted=" + trainingCompleted + ", salary=" + salary + "]";
	}
	
}
