package com.sahu.chinmaya.employeeserver.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sahu.chinmaya.employeeserver.config.Config;
import com.sahu.chinmaya.employeeserver.db.EmployeeService;

@SpringBootApplication 
@EnableJpaRepositories (basePackages = "com.sahu.chinmaya.employeeserver.db")
public class EmployeeServerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Config.class, args);
		
		EmployeeService service = ctx.getBean(EmployeeService.class);
		System.out.println(service.getAllEmployees());
		
		//ACCESS SWAGGER
		//http://localhost:8080/swagger-ui.html
	}

}
