package com.sahu.chinmaya.employeeserver.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahu.chinmaya.employeeserver.config.Config;
import com.sahu.chinmaya.employeeserver.controller.AppController;
import com.sahu.chinmaya.employeeserver.db.Department;
import com.sahu.chinmaya.employeeserver.db.EmpGender;
import com.sahu.chinmaya.employeeserver.db.Employee;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(AppController.class)
@ContextConfiguration(classes=Config.class)
public class AppControllerE2ETest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testFetchEmployeeList() throws Exception
	{
		String uri = "/getAllEmployees";
	    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Employee[] employees = mapFromJson(content, Employee[].class);
	      assertTrue(employees.length > 0);
	}
	
	@Test
	public void testCreateEmployee() throws Exception
	{
		String uri = "/createEmployee";
		
		Employee employee =new Employee();
		employee.setDepartment(new Department(101L, "HR"));
		employee.setFirstName("Test");
		employee.setLastName("Test");
		employee.setGender(EmpGender.FEMALE);
		employee.setDob(LocalDate.parse("1985-02-01"));
		
		String inputJson = mapToJson(employee);
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson)).andReturn();
		      
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.contains("Test"));
	}
	
	
	protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		      ObjectMapper objectMapper = new ObjectMapper();
		      return objectMapper.readValue(json, clazz);
    }
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	

}
