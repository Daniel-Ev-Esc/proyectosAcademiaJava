package com.curso.v0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObserverTest {

	@Test
	void getMeetingState() {
		
		Meeting meeting = new Meeting("Daily SCRUM", "11:30", 7,"august",2024);		
		
		String meetingInfo = meeting.getInformation();
		
		assertEquals("Daily SCRUM: august 7 2024, 11:30", meetingInfo);		
		
	}
	
	@Test
	void setMeetingState() {
		
		Meeting meeting = new Meeting("Daily SCRUM", "11:30", 7,"august",2024);	
		
		meeting.setName("Sprint Retrospective");
		meeting.setHour("13:00");
		meeting.setDay(15);
		meeting.setMonth("september");
		meeting.setYear(2025);
		
		String meetingInfo = meeting.getInformation();
		
		assertEquals("Sprint Retrospective: september 15 2025, 13:00", meetingInfo);		
			
	}
	
	@Test
	void getAdminState() {
		
		Meeting meeting = new Meeting("Daily SCRUM", "11:30", 7,"august",2024);	
		
		Admin admin = new Admin("Daniel Escalera", meeting);
		
		String meetingInfo = admin.getMeetingInfo();
		
		assertEquals("Daily SCRUM: august 7 2024, 11:30", meetingInfo);	
	}

	@Test
	void getPsrticipantState() {
		
		Meeting meeting = new Meeting("Daily SCRUM", "11:30", 7,"august",2024);	
		
		Participant participant = new Participant("Daniel Escalera", meeting);
		
		participant.update();
		
		String meetingInfo = participant.getMeetingInfo();
		
		assertEquals("Daily SCRUM: august 7 2024, 11:30", meetingInfo);	
	}
	
	@Test
	void observerCycle(){
		Meeting meeting = new Meeting("Daily SCRUM", "11:30", 7,"august",2024);
		
		Admin meetingAdmin1 = new Admin("Daniel Escalera",meeting);
		Admin meetingAdmin2 = new Admin("Jorge Martinez", meeting);
		Participant participant1 = new Participant("Pablo Ortiz", meeting);
		Participant participant2 = new Participant("Maria Garcia", meeting);
		
		meetingAdmin1.changeMeetingName("Emergency meeting");

		assertEquals("Emergency meeting: august 7 2024, 11:30", meetingAdmin1.getMeetingInfo());	
		assertEquals("Emergency meeting: august 7 2024, 11:30", meetingAdmin2.getMeetingInfo());
		assertEquals("Emergency meeting: august 7 2024, 11:30", participant1.getMeetingInfo());	
		assertEquals("Emergency meeting: august 7 2024, 11:30", participant2.getMeetingInfo());
		
		meetingAdmin2.changeMeetingDay(12, "september", 2024);
		meetingAdmin2.changeMeetingHour("12:00");
		
		assertEquals("Emergency meeting: september 12 2024, 12:00", meetingAdmin1.getMeetingInfo());	
		assertEquals("Emergency meeting: september 12 2024, 12:00", meetingAdmin2.getMeetingInfo());
		assertEquals("Emergency meeting: september 12 2024, 12:00", participant1.getMeetingInfo());	
		assertEquals("Emergency meeting: september 12 2024, 12:00", participant2.getMeetingInfo());
	}
}
