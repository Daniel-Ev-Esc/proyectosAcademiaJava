package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.entities.CustomMessage;
import com.em.entities.Employee;

public interface MessageRepository extends JpaRepository<CustomMessage, String>{
	
}
