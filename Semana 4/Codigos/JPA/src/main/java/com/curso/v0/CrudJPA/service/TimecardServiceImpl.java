package com.curso.v0.CrudJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.curso.v0.CrudJPA.dao.TimecardDAO;
import com.curso.v0.CrudJPA.entity.Timecard;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TimecardServiceImpl implements TimecardService{
	
    private TimecardDAO timecardDAO;
    
    @Autowired
    public TimecardServiceImpl(TimecardDAO timecardDAO) {
		this.timecardDAO = timecardDAO;
	}

    @Override
    public List<Timecard> findAll() {
    	return timecardDAO.findAll();
    }   

	@Override
    public Timecard findById(long theId) {
    	return timecardDAO.findById(theId);
    }
    
    @Override
    public List<Timecard> findByDepartment(String department) {
    	return timecardDAO.findByDepartment(department);
    }
   
    @Transactional
    @Override
    public Timecard save(Timecard theTimecard) {
    	return timecardDAO.save(theTimecard);
    }
    
    @Transactional
	@Override
	public void deleteById(long theId) {
		timecardDAO.deleteById(theId);		
	}
	
}
