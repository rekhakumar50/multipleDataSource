package com.example.demo.dao.employee;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name="phone_number", nullable = false)
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="emp_phone_numbers", joinColumns=@JoinColumn(name="emp_id"))
	private List<PhoneNumber> phoneNumbers;
	
	@Column(name = "total_experience", nullable = false)
	private Integer totalExperience;
	
	@Column(name = "department_code", nullable = false)
	private String departmentCode;
	
	@Column(name = "branch_code", nullable = false)
	private String branchCode;

}
