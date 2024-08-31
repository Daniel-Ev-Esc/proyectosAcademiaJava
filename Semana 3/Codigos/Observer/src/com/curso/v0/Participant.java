package com.curso.v0;

import java.util.Objects;

// Participants get notified if an element of their subscribed meeting changes
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
		Participant other = (Participant) obj;
		return Objects.equals(meeting, other.meeting) && Objects.equals(meetingInfo, other.meetingInfo)
				&& Objects.equals(name, other.name);
	}

}
