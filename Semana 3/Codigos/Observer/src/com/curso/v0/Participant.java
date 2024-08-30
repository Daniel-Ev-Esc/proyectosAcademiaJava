package com.curso.v0;

public class Participant extends Observer{
	
	private String name;
	private Meeting meeting;
	private String meetingInfo;
	
	public Participant(String name, Meeting meeting) {
		super(meeting);
		this.name = name;
		this.meeting = meeting;
		this.meetingInfo = meeting.getInformation();
	}
	
	void update(){
		meetingInfo = meeting.getInformation();
	};

	public String getMeetingInfo() {
		return meetingInfo;
	}

}
