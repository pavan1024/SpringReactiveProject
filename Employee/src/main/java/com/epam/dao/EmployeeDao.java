package com.epam.dao;

import java.time.Duration;

import org.springframework.stereotype.Component;

import com.epam.dto.Employee;

import reactor.core.publisher.Flux;
@Component
public class EmployeeDao {
	
	public Flux<Employee> getAllEmployees(){
		return Flux.range(1, 50)
				.delayElements(Duration.ofSeconds(1))
				.map(i->new Employee(i,"Employee","India"));
	}
	
}
