package com.curso.v0.CrudJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.curso.v0.CrudJPA.dao.TimecardRepository;
import com.curso.v0.CrudJPA.entity.Timecard;

@Service
public class TimecardServiceImpl implements TimecardService{
	
    private TimecardRepository timecardRepository;
    
    @Autowired
    public TimecardServiceImpl(TimecardRepository timecardRepository) {
		this.timecardRepository = timecardRepository;
	}

    @Override
    public List<Timecard> findAll() {
    	return timecardRepository.findAll();
    }   

	@Override
    public Timecard findById(long theId) {
    	Optional<Timecard> optionalTimecard = timecardRepository.findById(theId);

    	Timecard timecard = null;
    			
	    if (optionalTimecard.isPresent()) {
	       timecard = optionalTimecard.get();
	    }
	    else {
           throw new RuntimeException("Did not find employee id - " + theId);
	    }

       return timecard;
    }
    
    @Override
    public List<Timecard> findByDepartment(String department) {
    	return timecardRepository.findByDepartment(department);
    }
   
    @Override
    public Timecard save(Timecard theTimecard) {
    	return timecardRepository.save(theTimecard);
    }
    
	@Override
	public void deleteById(long theId) {
		timecardRepository.deleteById(theId);		
	}
	
}
