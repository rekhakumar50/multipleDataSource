package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.employee.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployees() {
		List<EmployeeDto> employees = EmployeeMapper.convertToEmployeeDto(employeeRepository.findAll());
		return new ResponseEntity<List<EmployeeDto>>(employees, HttpStatus.OK);
	}
	
}
