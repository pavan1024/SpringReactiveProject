package com.epam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.EmployeeDao;
import com.epam.dto.Employee;

import reactor.core.publisher.Flux;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	
	public Flux<Employee> loadAllEmployees(){
		Flux<Employee> employees = dao.getAllEmployees();
		return employees;
		
	}
}
