package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.repository.department.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getDepartments() {
		List<DepartmentDto> departments = DepartmentMapper.convertToDepartmentDto(departmentRepository.findAll());
		return new ResponseEntity<List<DepartmentDto>>(departments, HttpStatus.OK);
	}
	

}
