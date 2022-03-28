package com.epam.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.epam.dto.Employee;
import com.epam.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(EmployeeController.class)
@Import(EmployeeService.class)
class EmployeeControllerTest {
	@Autowired
	WebTestClient webTestClient;
	@MockBean
	private EmployeeService employeeService;

	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee(1, "Test", "Tests");
		Mono<Employee> employeeMono = Mono.just(employee);
		when(employeeService.addEmployee(employee)).thenReturn(employeeMono);
		webTestClient.post().uri("/employees").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(employee), Employee.class).exchange().expectStatus().isOk().expectBody();
	}

	@Test
	public void testGetEmployee() {
		Employee employee = new Employee(1, "Test", "Tests");
		Flux<Employee> employeeFlux = Flux.just(employee);
		when(employeeService.loadAllEmployees()).thenReturn(employeeFlux);
		webTestClient.get().uri("/employees").exchange().expectStatus().isOk().expectBodyList(Employee.class);
	}

}
