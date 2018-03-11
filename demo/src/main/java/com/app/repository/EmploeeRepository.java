package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Employee;

@Repository
public interface EmploeeRepository extends JpaRepository<Employee, Integer> {

}
