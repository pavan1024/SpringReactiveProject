package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.Employee;
import com.epam.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/employees",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public Flux<Employee> getAllEmployees(){
		return service.loadAllEmployees();
	}
	
	@PostMapping
	public Mono<Employee> addEmployee(@RequestBody Employee employee){
		return service.addEmployee(employee);
	}
}
