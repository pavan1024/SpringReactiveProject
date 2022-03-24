package com.epam.dao;


import org.springframework.stereotype.Component;

import com.epam.dto.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class EmployeeDao {
	Flux<Employee> employees = Flux.empty();
	public Flux<Employee> getAllEmployees(){
		return employees;
	}
	
	
	public Mono<Employee> addEmployee(Employee employee){
		Mono<Employee> savedEmployee = Mono.just(employee);
		employees = Flux.concat(employees,savedEmployee);
		return savedEmployee;
	}
	
	
}
