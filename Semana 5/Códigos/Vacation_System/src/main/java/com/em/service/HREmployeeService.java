package com.em.service;

import java.util.List;

import com.em.entities.HREmployee;

public interface HREmployeeService {

	List<HREmployee> getAll();

	HREmployee findById(int theId);

	HREmployee save(HREmployee hrEmployee);

	void deleteById(int theId);

}
