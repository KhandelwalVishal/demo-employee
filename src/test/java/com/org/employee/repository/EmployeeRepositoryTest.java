package com.org.employee.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.employee.dao.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void saveEmployeeDetails() {
		Employee emp = new Employee();
		emp.setEmpName("Employee1");
		emp.setAddress("Address");
		assertNotNull(employeeRepository.save(emp));
	}

}
