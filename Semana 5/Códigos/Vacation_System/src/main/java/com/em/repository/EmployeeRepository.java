package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
