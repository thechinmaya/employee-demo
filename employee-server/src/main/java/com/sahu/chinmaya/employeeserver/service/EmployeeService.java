package com.sahu.chinmaya.employeeserver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sahu.chinmaya.employeeserver.db.Employee;
import com.sahu.chinmaya.employeeserver.db.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Transactional
	public Employee saveEmployee(Employee employee)
	{
	   return employeeRepo.save(employee);
	}
	
	public List<Employee> getAllEmployees()
	{
		return employeeRepo.findAll();
	}
	
	public List<Employee> getAllEmployeesSortedByFirstName()
	{
		return employeeRepo.findAllByOrderByFirstName();
	}

}
