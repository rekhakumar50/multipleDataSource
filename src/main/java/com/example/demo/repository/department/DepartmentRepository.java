package com.example.demo.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.department.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}
