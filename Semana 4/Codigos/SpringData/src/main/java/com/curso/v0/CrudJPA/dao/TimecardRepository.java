package com.curso.v0.CrudJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.v0.CrudJPA.entity.Timecard;

public interface TimecardRepository extends JpaRepository<Timecard, Long>{
	
	List<Timecard> findByDepartment(String department);

}
