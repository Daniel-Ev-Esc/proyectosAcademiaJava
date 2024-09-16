package com.em.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.em.entities.HREmployee;
import com.em.repository.HREmployeeRepository;

@Service
public class HREmployeeServiceImpl implements HREmployeeService {
	
	HREmployeeRepository hrEmployeeRepository;

	public HREmployeeServiceImpl(HREmployeeRepository hrEmployeeRepository) {
		this.hrEmployeeRepository = hrEmployeeRepository;
	}

	@Override
	public List<HREmployee> getAll() {
		return hrEmployeeRepository.findAll();
	}

	@Override
	public HREmployee findById(int theId) {
		Optional<HREmployee> result = hrEmployeeRepository.findById(theId);
		
		HREmployee theHREmployee = null;
				
		if(result.isPresent()) {
			theHREmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theHREmployee;
	}
	
	@Override
	public HREmployee save(HREmployee hrEmployee) {
		return hrEmployeeRepository.save(hrEmployee);
	}
	
	@Override
	public void deleteById(int theId) {
		hrEmployeeRepository.deleteById(theId);
	}
	
	@Override
	public HREmployee findByEmail(String email) {
		// TODO Auto-generated method stub
		return hrEmployeeRepository.findByEmail(email);
	}
}
