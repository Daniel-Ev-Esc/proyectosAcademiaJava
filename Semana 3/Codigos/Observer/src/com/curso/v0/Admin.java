package com.curso.v0;

public class Admin extends Observer{
	
	private String name;
	private Meeting meeting;
	private String meetingInfo;

	public Admin(String name, Meeting meeting) {
		super(meeting);
		this.name = name;
		this.meeting = meeting;
		this.meetingInfo = meeting.getInformation();
	}
	
	void update(){
		meetingInfo = meeting.getInformation();
	};
	
	void changeMeetingName(String name) {
		meeting.setName(name);
	}
	
	void changeMeetingHour(String hour) {
		meeting.setHour(hour);
	}
	
	void changeMeetingDay(int day, String month, int year) {
		meeting.setDay(day);
		meeting.setMonth(month);
		meeting.setYear(year);
	}

	public String getMeetingInfo() {
		return meetingInfo;
	}

}
