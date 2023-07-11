package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.example.demo.dao.department.Department;
import com.example.demo.dto.DepartmentDto;

public interface DepartmentMapper {
	
	public static List<DepartmentDto> convertToDepartmentDto(List<Department> departments) {
		List<DepartmentDto> departmentDtos = null;
		if(CollectionUtils.isNotEmpty(departments)) {
			departmentDtos = departments.stream().map(department -> {
									DepartmentDto departmentDto = new DepartmentDto();
									departmentDto.setId(department.getId());
									departmentDto.setDepartmentName(department.getDepartmentName());
									departmentDto.setDepartmentDesc(department.getDepartmentDesc());
									departmentDto.setDepartmentCode(department.getDepartmentCode());
									return departmentDto;
								}).collect(Collectors.toList());
		}
		
		return departmentDtos;
	}

}
