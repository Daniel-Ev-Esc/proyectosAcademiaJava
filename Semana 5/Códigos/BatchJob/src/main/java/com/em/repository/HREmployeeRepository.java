package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.entities.HREmployee;

public interface HREmployeeRepository extends JpaRepository<HREmployee, Integer>{

}
