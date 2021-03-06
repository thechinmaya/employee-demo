package com.sahu.chinmaya.employeeserver.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public List<Employee> findAllByOrderByFirstName();
}
