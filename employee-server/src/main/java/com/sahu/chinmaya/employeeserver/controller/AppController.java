package com.sahu.chinmaya.employeeserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.chinmaya.employeeserver.db.Employee;
import com.sahu.chinmaya.employeeserver.db.EmployeeService;

@RestController
public class AppController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/getAllEmployees", method= RequestMethod.GET)
	public @ResponseBody List<Employee> fetchEmployeeList()
	{
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value = "/createEmployee",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> create(Employee employee)
	{
		if(employee != null)
		{
			return ResponseEntity.ok(employeeService.saveEmployee(employee));
		}
		return ResponseEntity.badRequest().body("Failed while processing");
	}
	
}
