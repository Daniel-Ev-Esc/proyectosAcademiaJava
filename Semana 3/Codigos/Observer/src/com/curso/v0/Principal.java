package com.curso.v0;

public class Principal {
	public static void main(String[] args) {
		Meeting meeting = new Meeting("Daily SCRUM", "11:30", 7,"august",2024);
		
		Admin meetingAdmin1 = new Admin("Daniel Escalera",meeting);
		Admin meetingAdmin2 = new Admin("Jorge Martinez", meeting);
		Participant participant1 = new Participant("Pablo Ortiz", meeting);
		Participant participant2 = new Participant("Maria Garcia", meeting);
		
		System.out.println("	--- Admin 1 change ---	");
		
		meetingAdmin1.changeMeetingName("Emergency meeting");

        System.out.println("Admin 1 info: " + meetingAdmin1.getMeetingInfo());	
        System.out.println("Admin 2 info: " + meetingAdmin2.getMeetingInfo());
        System.out.println("Participant 1 info: " + participant1.getMeetingInfo());
        System.out.println("Participant 2 info: " + participant2.getMeetingInfo());
		
        System.out.println("	--- Admin 2 change ---	");
        
		meetingAdmin2.changeMeetingDay(12, "september", 2024);
		meetingAdmin2.changeMeetingHour("12:00");
		
		
		System.out.println("Admin 1 info: " + meetingAdmin1.getMeetingInfo());	
		System.out.println("Admin 2 info: " + meetingAdmin2.getMeetingInfo());
		System.out.println("Participant 1 info: " + participant1.getMeetingInfo());	
		System.out.println("Participant 2 info: " + participant2.getMeetingInfo());

	}
}
