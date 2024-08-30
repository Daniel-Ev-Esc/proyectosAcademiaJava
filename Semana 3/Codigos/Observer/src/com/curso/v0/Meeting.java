package com.curso.v0;

public class Meeting extends Subject {
	
	private String name;
	private String hour;
	private int day;
	private String month;
	private int year;
	
	public Meeting(String name, String hour, int day, String month, int year) {
		this.name = name;
		this.hour = hour;
		this.day = day;
		this.month = month;
		this.year = year;
	}	
	
	public void setName(String name) {
		this.name = name;
		notificar();
	}

	public void setHour(String hour) {
		this.hour = hour;
		notificar();
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
		notificar();
	}

	public String getInformation() {
		return name + ": " + month + " " + day + " " + year + ", " + hour;
	}
	
	

}
