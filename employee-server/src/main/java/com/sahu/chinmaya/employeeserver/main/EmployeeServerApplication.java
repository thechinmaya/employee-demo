package com.sahu.chinmaya.employeeserver.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sahu.chinmaya.employeeserver.config.Config;
import com.sahu.chinmaya.employeeserver.service.EmployeeService;

@SpringBootApplication 
@EnableJpaRepositories (basePackages = "com.sahu.chinmaya.employeeserver.db")
public class EmployeeServerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Config.class, args);
		
		//ACCESS SWAGGER
		//http://localhost:8080/api/swagger-ui.html
	}

}
