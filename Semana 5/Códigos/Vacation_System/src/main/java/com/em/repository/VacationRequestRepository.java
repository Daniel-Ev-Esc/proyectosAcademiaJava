package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.entities.VacationRequest;

public interface VacationRequestRepository extends JpaRepository<VacationRequest, Integer>{

}
