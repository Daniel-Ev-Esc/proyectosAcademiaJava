package com.curso.v0.Batch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.v0.Batch.entity.Timecard;


public interface TimecardRepository extends JpaRepository<Timecard, Long>{
	
}
