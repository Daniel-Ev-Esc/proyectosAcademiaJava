package com.curso.v0;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// From an employee list get the 5 top employees and increase their salaries
public class Principal {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
        
		employees.add(new Employee("Alice Smith", 35, true, true, 5500.00));
        employees.add(new Employee("Bob Johnson", 40, false, true, 6000.00));
        employees.add(new Employee("Charlie Davis", 28, true, false, 4700.00));
        employees.add(new Employee("Diana Clark", 45, true, true, 6200.00));
        employees.add(new Employee("Edward Brown", 32, false, false, 5300.00));
        employees.add(new Employee("Fiona Wilson", 38, true, true, 5800.00));
        employees.add(new Employee("George Lee", 25, false, true, 4500.00));
        employees.add(new Employee("Hannah King", 42, true, false, 5900.00));
        employees.add(new Employee("Isaac Turner", 30, false, false, 5000.00));
        employees.add(new Employee("Jasmine Young", 36, true, true, 5700.00));
        employees.add(new Employee("Kevin Adams", 33, true, true, 5400.00));
        employees.add(new Employee("Laura Martinez", 29, false, true, 4000.00));
        employees.add(new Employee("Michael Brown", 41, true, false, 6100.00));
        employees.add(new Employee("Nina Wilson", 39, true, true, 6000.00));
        employees.add(new Employee("Oliver Scott", 27, false, false, 4600.00));
        employees.add(new Employee("Pamela Turner", 31, true, true, 5200.00));
        employees.add(new Employee("Quincy Lewis", 36, false, true, 4900.00));
        employees.add(new Employee("Rachel Green", 43, true, false, 6000.00));
        employees.add(new Employee("Samuel White", 30, false, true, 5100.00));
        employees.add(new Employee("Tina Evans", 37, true, true, 5600.00));
		
        List<Employee> topEmployees = employees.stream()
			.filter(x -> x.isReportsFilled() && x.isTrainingCompleted()) // Get the employees whose training is complete and reports are filled
			.sorted((e1, e2) -> e2.getWorkHours() - e1.getWorkHours()) // Sort them in descendnig order
			.limit(5) // Get the first 5
			.peek(x -> x.setSalary(x.getSalary() + x.getSalary()*.15)) // Increase their salaries
			.collect(Collectors.toList()); // Save them on a list
		
        for (Employee employee : topEmployees) {
			System.out.println(employee);
		}
	}

}
