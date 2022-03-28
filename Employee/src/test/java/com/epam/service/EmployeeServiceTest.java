package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.dao.EmployeeDao;
import com.epam.dto.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class EmployeeServiceTest {
	
	@Autowired
	EmployeeService service;
	
	@MockBean
	EmployeeDao dao;

	@Test
	void testLoadAllEmployees() {
		Employee employee = new Employee(1,"Test","Loc");
		Employee employee1 = new Employee(2,"Test1","Loc1");
		Flux<Employee> fluxEmployees = Flux.just(employee,employee1);
		when(service.loadAllEmployees()).thenReturn(fluxEmployees);
		assertEquals(fluxEmployees,service.loadAllEmployees());
	}
	
	@Test
	void testAddEmployee() {
		Employee employee = new Employee(1,"Test","Loc");
		Mono<Employee> monoEmployee = Mono.just(employee);
		when(service.addEmployee(employee)).thenReturn(monoEmployee);
		assertEquals(monoEmployee,service.addEmployee(employee));
	}

}
