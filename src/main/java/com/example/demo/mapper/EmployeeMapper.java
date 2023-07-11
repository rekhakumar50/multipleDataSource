package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.example.demo.dao.employee.Employee;
import com.example.demo.dto.EmployeeDto;

public interface EmployeeMapper {
	
	public static List<EmployeeDto> convertToEmployeeDto(List<Employee> employees) {
		List<EmployeeDto> employeeDtos = null;
		if(CollectionUtils.isNotEmpty(employees)) {
			employeeDtos = employees.stream().map(employee -> {
									EmployeeDto employeeDto = new EmployeeDto();
									employeeDto.setId(employee.getId());
									employeeDto.setFirstName(employee.getFirstName());
									employeeDto.setLastName(employee.getLastName());
									employeeDto.setEmail(employee.getEmail());
									employeeDto.setPhoneNumbers(employee.getPhoneNumbers());
									employeeDto.setTotalExperience(employee.getTotalExperience());
									return employeeDto;
								}).collect(Collectors.toList());
		}
		
		return employeeDtos;
	}
	
}
