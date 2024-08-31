package com.curso.v0;

import java.util.Objects;

// Class that can manage a meeting
public class Admin extends Observer{
	
	private String name;
	private Meeting meeting;
	private String meetingInfo;

	// Stores the meeting to manage it
	public Admin(String name, Meeting meeting) {
		super(meeting);
		this.name = name;
		this.meeting = meeting;
		this.meetingInfo = meeting.getInformation();
	}
	
	// On update, changes the meeting information, this is done so two or more admins can managa a meeting
	@Override
	void update(){
		meetingInfo = meeting.getInformation();
	};
	
	// Methods that change the meeting details
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

	@Override
	public int hashCode() {
		return Objects.hash(meeting, meetingInfo, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(meeting, other.meeting) && Objects.equals(meetingInfo, other.meetingInfo)
				&& Objects.equals(name, other.name);
	}

}
