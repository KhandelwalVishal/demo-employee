package com.org.employee.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.Mock;

import com.org.employee.dao.Employee;
import com.org.employee.repository.EmployeeRepository;

public class EmployeeServiceImplTest {

	private EmployeeServiceImpl employeeServiceImpl;

	@Mock
	private EmployeeRepository employeeRepository;

	@Test
	public void testAddEmployee() {
		Employee emp = new Employee();
		emp.setEmpName("Vishal");
		emp.setAddress("97 Morningside Drive");
		emp.setDateOfBirth("1988-04-07");
		emp.setContactNumber("6478038513");
		emp.setTitle("Developer");
		emp.setSin("12345678");
		assertNotNull(employeeServiceImpl.addEmployee(emp));
	}

	@Test
	public void testGetAllEmployees() {
		assertNotNull(employeeServiceImpl.getAllEmployees());
	}

	@Test
	public void testGetFilteredEmployees() {
		assertNotNull(employeeServiceImpl.getFilteredEmployees(30, "Developer"));
		assertNotNull(employeeServiceImpl.getFilteredEmployees(36, "Developer"));
	}

}
