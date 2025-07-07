package com.msexample.employee_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.msexample.employee_service.model.Employee;

@Repository
public class EmployeeRepository {
	private List<Employee> employees = new ArrayList<>();

	public Employee addEmployee(Employee Employee) {
		employees.add(Employee);
		return Employee;
	}

	public Employee findById(Long id) {
		return employees.stream().filter(employee -> employee.id().equals(id)).findFirst().orElseThrow();
	}

	public List<Employee> findAll() {
		return employees;
	}
	
	public List<Employee> findByDepartmentId(Long departmentId) {
		return employees.stream().filter(employee -> employee.departmentId().equals(departmentId)).toList();
	}
}
