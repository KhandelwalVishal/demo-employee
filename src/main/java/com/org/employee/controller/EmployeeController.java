package com.org.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.employee.dao.Employee;
import com.org.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/getEmployeeByAgeAndTitle")
	public List<Employee> getEmployeeByAgeAndTitle(@RequestParam int age,
			@RequestParam String title) {
		return empService.getFilteredEmployees(age, title);
	}

	@PostMapping("/saveEmployeeDetails")
	public Employee saveEmployeeDetails(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}

}
