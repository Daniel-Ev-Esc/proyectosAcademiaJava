package com.em.service;


import java.time.LocalDate;
import java.util.List;

import com.em.entities.VacationRequest;
import com.em.enumerators.Status;

public interface VacationRequestService {

	VacationRequest makeRequest(int employeeId, LocalDate startDate, LocalDate endDate, Status status, String reason);

	VacationRequest assignRequest(int vrId, int hrId);

	VacationRequest acceptRequest(int vrId);

	VacationRequest rejectRequest(int vrId);

	List<VacationRequest> getAll();

	VacationRequest getById(int id);

}
