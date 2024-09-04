package com.org.employee.dao;

import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class EmployeeTest {

	protected Validator pojoValidater;

	@Before
	public void stepUp() throws Exception {
		pojoValidater = ValidatorBuilder.create().with(new SetterMustExistRule()).with(new GetterMustExistRule())
				.with(new SetterTester()).with(new GetterTester()).build();
	}

	@Test
	public void testEmployeeDomain() {
		pojoValidater.validate(PojoClassFactory.getPojoClass(Employee.class));
	}

}
