package com.sahu.chinmaya.employeeserver.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sahu.chinmaya.employeeserver.db.Department;
import com.sahu.chinmaya.employeeserver.db.EmpGender;
import com.sahu.chinmaya.employeeserver.db.Employee;
import com.sahu.chinmaya.employeeserver.db.EmployeeRepo;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

	@Mock
	EmployeeRepo employeeRepo;
	
	@InjectMocks
	EmployeeService employeeService = new EmployeeService();
	
	@Test
	public void testSaveEmployee()
	{
		Employee employee =new Employee();
		employee.setDepartment(new Department(101L, "HR"));
		employee.setFirstName("Test");
		employee.setLastName("Test");
		employee.setGender(EmpGender.FEMALE);
		employee.setDob(LocalDate.parse("1985-02-01"));
		
		Mockito.when(employeeRepo.save(Mockito.any(Employee.class))).thenReturn(employee);
		
		Employee result=employeeService.saveEmployee(employee);
		
		Assert.assertNotNull(result);
		Assert.assertEquals("Test", result.getFirstName());
		
	}
	
}
