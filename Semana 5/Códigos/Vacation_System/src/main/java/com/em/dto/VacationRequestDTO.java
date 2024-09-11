package com.em.dto;

import java.time.LocalDate;

import com.em.enumerators.Status;

public class VacationRequestDTO {
	
	private int employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private String reason;
    
	public VacationRequestDTO(int employeeId, LocalDate startDate, LocalDate endDate, Status status, String reason) {
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.reason = reason;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
    
}
