package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Employee;
import com.app.repository.EmploeeRepository;

@Transactional
@Service
public class EmployeeService {
	@Autowired
	EmploeeRepository emploeeRepository;

	public Employee addEmployee(Employee employee) {
		return emploeeRepository.save(employee);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployee() {
		return emploeeRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Employee getEmployeeById(Integer id) {
		return emploeeRepository.findOne(id);
	}
	
}
