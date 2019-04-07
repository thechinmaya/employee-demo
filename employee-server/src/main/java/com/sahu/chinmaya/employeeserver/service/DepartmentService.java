package com.sahu.chinmaya.employeeserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.chinmaya.employeeserver.db.Department;
import com.sahu.chinmaya.employeeserver.db.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepo departmentRepo;
	
	public List<Department> getDepartments()
	{
		return departmentRepo.findAll();
	}

}
