package com.curso.v0.CrudJPA.service;

import java.util.List;

import com.curso.v0.CrudJPA.entity.Timecard;

public interface TimecardService {
	
	List<Timecard> findAll();
    
    List<Timecard> findByDepartment(String department);

    Timecard findById(long theId);

    Timecard save(Timecard theTimecard);

    void deleteById(long theId);
}
