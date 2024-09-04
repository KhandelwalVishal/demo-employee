package com.org.employee.service;

import java.util.List;

import com.org.employee.dao.Employee;
public interface EmployeeService {
	
	Employee addEmployee(Employee emp);
	List<Employee> getAllEmployees();
	List<Employee> getFilteredEmployees(int age, String title);

}
