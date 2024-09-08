package com.curso.v0.CrudJPA.rest;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.v0.CrudJPA.entity.Timecard;
import com.curso.v0.CrudJPA.service.TimecardService;
import com.curso.v0.CrudJPA.service.TimecardServiceImpl;

@RestController
@RequestMapping("/timecard-system")
public class TimecardRestController {
	
	private TimecardService timecardService;
	
	@Autowired
	public TimecardRestController(TimecardService timecardService) {
		this.timecardService = timecardService;
	}

	@GetMapping("timecards")
	public List<Timecard> getTimecards(){
		return timecardService.findAll();
	}
	
	@GetMapping("timecards/{id}")
	public Timecard TimecardById(@PathVariable long id){
		
	    Timecard theTimecard = timecardService.findById(id);

	    if (theTimecard == null) {
	    	throw new RuntimeException("Timecard id not found - " + id);
		}
	    
	    return theTimecard;
	}
	
	@GetMapping("timecards/department/{department}")
	public List<Timecard> getTimecard(@PathVariable String department) {
		return timecardService.findByDepartment(department);
	}
	
	@PostMapping("timecards")
	public Timecard addTimecard(@RequestBody Timecard theTimecard) {
		
		theTimecard.setId(0);
		Timecard dbTimecard = timecardService.save(theTimecard);
		return dbTimecard;
	}
	
	@PutMapping("timecards")
	public Timecard updateTimecard(@RequestBody Timecard theTimecard) {
		Timecard dbTimecard = timecardService.save(theTimecard);
		return dbTimecard;
	}
	
	@DeleteMapping("timecards/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		// Find the timecard by ID
	    Timecard theTimecard = timecardService.findById(id);

	    if (theTimecard == null) {
	    	throw new RuntimeException("Timecard id not found - " + id);
		}
	    
	    timecardService.deleteById(id);	    
	    
		return ResponseEntity.ok("Timecard deleted successfully, id: " + id);
	}
	
}
