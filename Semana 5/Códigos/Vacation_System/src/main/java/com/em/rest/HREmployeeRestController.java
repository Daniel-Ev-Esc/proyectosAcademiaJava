package com.em.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.entities.HREmployee;
import com.em.service.HREmployeeService;

@RestController
@RequestMapping("/hr/")
public class HREmployeeRestController {

    private HREmployeeService hrEmployeeService;

    @Autowired
    public HREmployeeRestController(HREmployeeService theHREmployeeService) {
        hrEmployeeService = theHREmployeeService;
    }

    @GetMapping("/employees")
    public List<HREmployee> getAll() {
        return hrEmployeeService.getAll();
    }
    
    @GetMapping("/employees/{id}")
    public HREmployee getById(@PathVariable int id) {
    	
    	HREmployee theHREmployee = hrEmployeeService.findById(id);
    	
    	return theHREmployee;
    }
    
    @PostMapping("/employees")
    public HREmployee create(@RequestBody HREmployee theHREmployee) {
    	
    	theHREmployee.setId(0);
    	
        HREmployee dbHREmployee = hrEmployeeService.save(theHREmployee);

        return dbHREmployee;
    }
    
    @PutMapping("/employees")
    public HREmployee update(@RequestBody HREmployee theHREmployee) {
    	HREmployee dbHREmployee = hrEmployeeService.save(theHREmployee);

        return dbHREmployee;
    }
    
    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id) {
    	hrEmployeeService.deleteById(id);
    }
}
