package com.app.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		employee = employeeService.addEmployee(employee);
		if (employee == null || employee.getEmpId() == 0) {
			throw new RuntimeException("INVALID");
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		List<Employee> employees = employeeService.getAllEmployee();
		if (employees.isEmpty()) {
			throw new RuntimeException("INVALID");
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {

		Employee employee = employeeService.getEmployeeById(id);
		if (employee == null) {
			throw new RuntimeException("INVALID");
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
