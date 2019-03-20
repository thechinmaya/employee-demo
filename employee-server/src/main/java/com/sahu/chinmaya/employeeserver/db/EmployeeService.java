package com.sahu.chinmaya.employeeserver.db;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Transactional
	public Employee saveEmployee(Employee employee)
	{
		System.out.println(employee);
	   return employeeRepo.save(employee);
	}
	
	public List<Employee> getAllEmployees()
	{
		return employeeRepo.findAll();
	}

}
