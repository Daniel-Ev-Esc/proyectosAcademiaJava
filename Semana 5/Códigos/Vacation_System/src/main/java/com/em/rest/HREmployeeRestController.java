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

import com.em.dto.EmployeeDTO;
import com.em.entities.Employee;
import com.em.entities.HREmployee;
import com.em.service.HREmployeeService;
import com.em.service.UserService;

@RestController
@RequestMapping("/hr/")
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular app hosted on localhost:4200
public class HREmployeeRestController {

    private HREmployeeService hrEmployeeService;
	private UserService userService;

    @Autowired
    public HREmployeeRestController(HREmployeeService theHREmployeeService, UserService userService) {
        hrEmployeeService = theHREmployeeService;
        this.userService = userService;  
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
    
    @GetMapping("/employees/get-profile/{email}")
	public HREmployee getByEmail(@PathVariable String email) {
		return hrEmployeeService.findByEmail(email);
	}
    
    @PostMapping("/employees")
    public HREmployee create(@RequestBody EmployeeDTO theEmployee) {
    	
    	HREmployee theRealEmployee = new HREmployee();
    	
    	theRealEmployee.setId(0);
    	theRealEmployee.setName(theEmployee.getName());
    	theRealEmployee.setLastName(theEmployee.getLastName());
    	theRealEmployee.setEmail(theEmployee.getEmail());
    	
    	userService.createUser(theEmployee.getEmail(), theEmployee.getPass(), "HR");
    	
        HREmployee dbEmployee = hrEmployeeService.save(theRealEmployee);

        return dbEmployee;
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
