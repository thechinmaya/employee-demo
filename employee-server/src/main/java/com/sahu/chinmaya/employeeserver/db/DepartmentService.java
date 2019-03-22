package com.sahu.chinmaya.employeeserver.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepo departmentRepo;
	
	public List<Department> getDepartments()
	{
		return departmentRepo.findAll();
	}

}
