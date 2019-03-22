package com.sahu.chinmaya.employeeserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.chinmaya.employeeserver.db.Department;
import com.sahu.chinmaya.employeeserver.db.DepartmentService;
import com.sahu.chinmaya.employeeserver.db.EmpGender;
import com.sahu.chinmaya.employeeserver.db.Employee;
import com.sahu.chinmaya.employeeserver.db.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AppController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "/getAllEmployees", method= RequestMethod.GET)
	public @ResponseBody List<Employee> fetchEmployeeList()
	{
		return employeeService.getAllEmployeesSortedByFirstName();
	}
	
	@RequestMapping(value = "/getAllDepartments", method= RequestMethod.GET)
	public @ResponseBody List<Department> fetchDepartmentList()
	{
		return departmentService.getDepartments();
	}
	
	@RequestMapping(value = "/getAllGenders", method= RequestMethod.GET)
	public @ResponseBody List<String> fetchGenderList()
	{
		return EmpGender.names();
	}
	
	@RequestMapping(value = "/createEmployee",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> create(@RequestBody Employee employee)
	{
		if(employee != null)
		{
			return ResponseEntity.ok(employeeService.saveEmployee(employee));
		}
		return ResponseEntity.badRequest().body("Failed while processing");
	}
	
	
}
