package com.test;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String name;
	private int salary;
	private String department;
	private LocalDate joiningDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", joiningDate=" + joiningDate + "]";
	}

	public Employee(int id, String name, int salary, String department, LocalDate joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.joiningDate = joiningDate;
	}

	public Employee() {
		super();
	}

}
