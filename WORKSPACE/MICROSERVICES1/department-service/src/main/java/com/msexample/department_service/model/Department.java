package com.msexample.department_service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private Long id;
	private String name;
	private List<Employee> emlpoyees = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmlpoyees() {
		return emlpoyees;
	}

	public void setEmlpoyees(List<Employee> emlpoyees) {
		this.emlpoyees = emlpoyees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", emlpoyees=" + emlpoyees + "]";
	}

	public Department() {
		super();
	}

	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
