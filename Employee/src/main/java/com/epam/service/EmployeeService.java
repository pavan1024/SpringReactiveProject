package com.epam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.EmployeeDao;
import com.epam.dto.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	
	public Flux<Employee> loadAllEmployees(){
		return dao.getAllEmployees();
		
	}
	
	public Mono<Employee> addEmployee(Employee employee){
		return dao.addEmployee(employee);
	}
}
