package com.example.demo.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
