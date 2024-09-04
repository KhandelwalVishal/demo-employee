package com.org.employee.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.org.employee.dao.Employee;
import com.org.employee.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeService empService;

	@Test
	public void testGetAllEmployees() {
		assertNotNull(employeeController.getAllEmployees());
	}

	@Test
	public void testGetEmployeeByAgeAndTitle() {
		assertNotNull(employeeController.getEmployeeByAgeAndTitle(30, "Developer"));
	}

	@Test
	public void testSaveEmployeeDetails() {
		Employee emp = new Employee();
		emp.setEmpName("Vishal");
		emp.setAddress("97 Morningside Drive");
		emp.setDateOfBirth("1988-04-07");
		emp.setContactNumber("6478038513");
		emp.setTitle("Developer");
		emp.setSin("12345678");
		assertNotNull(employeeController.saveEmployeeDetails(emp));
	}

}
