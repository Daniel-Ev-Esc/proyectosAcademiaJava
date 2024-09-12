package com.em.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.em.entities.Employee;
import com.em.entities.VacationRequest;
import com.em.enumerators.Status;
import com.em.repository.EmployeeRepository;
import com.em.repository.HREmployeeRepository;
import com.em.repository.VacationRequestRepository;

@Service
public class VacationRequestServiceImpl implements VacationRequestService {

	EmployeeRepository eRepo;
	VacationRequestRepository vrRepo;
	HREmployeeRepository hrRepo;
	
	public VacationRequestServiceImpl(EmployeeRepository eRepo, VacationRequestRepository vrRepo, HREmployeeRepository hrRepo) {
		this.eRepo = eRepo;
		this.vrRepo = vrRepo;
		this.hrRepo = hrRepo;
	}
	
	@Override
	public List<VacationRequest> getAll() {
		return vrRepo.findAll();
	}
	
	@Override
	public VacationRequest getById(int id) {
		return vrRepo.findById(id)
				 .orElseThrow(() -> new RuntimeException("Request not found"));
	}
	
	@Override
	public VacationRequest makeRequest(int employeeId, LocalDate startDate, LocalDate endDate, Status status, String reason) {
		
        Employee employee = eRepo.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        VacationRequest vacationRequest = new VacationRequest(employee, startDate, endDate, status, reason);
        return vrRepo.save(vacationRequest);
	    
	}
	
	@Override
	public VacationRequest assignRequest(int vrId, int hrId) {
		
		VacationRequest vr = vrRepo.findById(vrId)
				 .orElseThrow(() -> new RuntimeException("Request not found"));
		
		vr.setHrEmployee(hrRepo.findById(hrId).orElseThrow(() -> new RuntimeException("Employee not found")));
		
		VacationRequest dbVacationRequest = vrRepo.save(vr);
		
		return dbVacationRequest;		
	}
	
	@Override
	public VacationRequest acceptRequest(int vrId) {
		VacationRequest vr = vrRepo.findById(vrId)
				 .orElseThrow(() -> new RuntimeException("Request not found"));;
				 
		vr.setStatus(Status.ACCEPTED);
		
		VacationRequest dbVacationRequest = vrRepo.save(vr);
		
		return dbVacationRequest;		
	}
	
	@Override
	public VacationRequest rejectRequest(int vrId) {
		VacationRequest vr = vrRepo.findById(vrId)
				 .orElseThrow(() -> new RuntimeException("Request not found"));;
				 
		vr.setStatus(Status.DECLINED);
		
		VacationRequest dbVacationRequest = vrRepo.save(vr);
		
		return dbVacationRequest;
	}
}
