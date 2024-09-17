package com.em.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.dto.EmployeeDTO;
import com.em.entities.Employee;
import com.em.service.EmployeeService;
import com.em.service.UserService;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular app hosted on localhost:4200
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	private UserService userService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, UserService userService) {
		this.employeeService = employeeService;
		this.userService = userService;
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
    public Employee create(@RequestBody EmployeeDTO theEmployee) {
    	
    	Employee theRealEmployee = new Employee();
    	
    	theRealEmployee.setId(0);
    	theRealEmployee.setName(theEmployee.getName());
    	theRealEmployee.setLastName(theEmployee.getLastName());
    	theRealEmployee.setDepartment(theEmployee.getDepartment());
    	theRealEmployee.setEmail(theEmployee.getEmail());
    	
    	userService.createUser(theEmployee.getEmail(), theEmployee.getPass(), "Employee");
    	
        Employee dbEmployee = employeeService.save(theRealEmployee);

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
