package com.org.employee.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.employee.dao.Employee;
import com.org.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee addEmployee(Employee emp) {
		emp.setSin(emp.getSin().length() > 4 ? emp.getSin().substring(emp.getSin().length() - 4) : emp.getSin());
		Employee addedEmployee = empRepository.save(emp);
		if (addedEmployee.getEmpId() != 0) {
			logger.info("Employee with Id: {} and Name: {} added to DB", addedEmployee.getEmpId(),
					addedEmployee.getEmpName());
		}
		return addedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	@Override
	public List<Employee> getFilteredEmployees(int age, String title) {
		return empRepository.findAll().stream().filter(e -> filterByAgeAndTitle(e, age, title))
				.collect(Collectors.toList());
	}

	private boolean filterByAgeAndTitle(Employee emp, int age, String title) {
		LocalDate dateOfBirth = LocalDate.parse(emp.getDateOfBirth());
		LocalDate curDate = LocalDate.now();
		return Period.between(dateOfBirth, curDate).getYears() >= age && emp.getTitle().equalsIgnoreCase(title);
	}

}
