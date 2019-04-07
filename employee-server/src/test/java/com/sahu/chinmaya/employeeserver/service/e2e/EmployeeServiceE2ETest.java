package com.sahu.chinmaya.employeeserver.service.e2e;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sahu.chinmaya.employeeserver.config.Config;
import com.sahu.chinmaya.employeeserver.db.Department;
import com.sahu.chinmaya.employeeserver.db.EmpGender;
import com.sahu.chinmaya.employeeserver.db.Employee;
import com.sahu.chinmaya.employeeserver.service.EmployeeService;


@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class EmployeeServiceE2ETest {
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void testGetAllEmployeesSortedByFirstName()
	{
		List<Employee> employeeList= employeeService.getAllEmployeesSortedByFirstName();
		Assert.assertEquals(4,employeeList.size());
		Assert.assertEquals("Alok", employeeList.get(0).getFirstName());
	}
	
	@Test
	public void testCreateEmployee() {
		Employee employee =new Employee();
		employee.setDepartment(new Department(101L, "HR"));
		employee.setFirstName("Test");
		employee.setLastName("Test");
		employee.setGender(EmpGender.FEMALE);
		employee.setDob(LocalDate.parse("1985-02-01"));
		
		Employee result=employeeService.saveEmployee(employee);
		
		Assert.assertNotNull(result);
		Assert.assertEquals("Test", result.getFirstName());
	}
	
	

}
