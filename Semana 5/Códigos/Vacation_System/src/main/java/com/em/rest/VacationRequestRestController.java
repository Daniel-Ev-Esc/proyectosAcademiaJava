package com.em.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.dto.VacationRequestDTO;
import com.em.entities.HREmployee;
import com.em.entities.VacationRequest;
import com.em.service.HREmployeeService;
import com.em.service.VacationRequestService;

@RestController
@RequestMapping("/vacation-requests")
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular app hosted on localhost:4200
public class VacationRequestRestController {

    private VacationRequestService vrService;

    @Autowired
    public VacationRequestRestController(VacationRequestService vrService) {
		this.vrService = vrService;
	}
    
    @GetMapping("")
    public List<VacationRequest> getAll() {
        return vrService.getAll();
    }
    
    @GetMapping("/{id}")
    public VacationRequest getById(@PathVariable int id){
    	return vrService.getById(id);
    }
    
    @PostMapping("/create")
    public VacationRequest createRequest(@RequestBody VacationRequestDTO vrDTO) {
    	return vrService.makeRequest(vrDTO.getEmployeeId(), 
    								 vrDTO.getStartDate(), 
    								 vrDTO.getEndDate(), 
    								 vrDTO.getStatus(), 
    								 vrDTO.getReason());    	    	
    }
    
    @PutMapping("/assign")
    public VacationRequest assignRequest(@RequestBody AssignerObj ab) {
    	return vrService.assignRequest(ab.getVacationRequestId(), ab.getHrEmployeeId());
    }
    
    @PutMapping("/accept/{vrId}")
    public VacationRequest acceptRequest(@PathVariable int vrId) {
    	return vrService.acceptRequest(vrId);
    }
    
    @PutMapping("/decline/{vrId}")
    public VacationRequest declineRequest(@PathVariable int vrId) {
    	return vrService.rejectRequest(vrId);
    }
};

class AssignerObj {
	private int vacationRequestId;
	private int hrEmployeeId;
	public int getVacationRequestId() {
		return vacationRequestId;
	}
	public int getHrEmployeeId() {
		return hrEmployeeId;
	}
}