package com.em.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.entities.Employee;
import com.em.service.EmployeeService;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular app hosted on localhost:4200
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
    
    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable int id) {
    	
    	Employee theEmployee = employeeService.findById(id);
    	
    	return theEmployee;
    }
    
    @GetMapping("/employees/get-profile/{email}")
	public Employee getByEmail(@PathVariable String email) {
		return employeeService.findByEmail(email);
	}
    
    @PostMapping("/employees")
    public Employee create(@RequestBody Employee theEmployee) {
    	
    	theEmployee.setId(0);
    	
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }
    
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee) {
    	Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }
    
    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id) {
    	employeeService.deleteById(id);
    }
}
