package com.test;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Simple {

	public static void main(String[] args) {
//		Finding highest paid employee from each department using streams.

		List<Employee> employees = List.of(new Employee(1, "Alice", 50000, "HR", LocalDate.of(2020, 5, 10)),
				new Employee(2, "Bob", 60000, "HR", LocalDate.of(2021, 5, 15)),
				new Employee(3, "Charlie", 70000, "IT", LocalDate.of(2019, 5, 10)),
				new Employee(4, "David", 80000, "IT", LocalDate.of(2022, 5, 18)),
				new Employee(5, "Eve", 75000, "Finance", LocalDate.of(2018, 5, 10)));

//		employees.stream().map(Comparator.comparingInt(Employee::salary))

		Map<String, Optional<Employee>> highestPaidByDept = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

		System.out.println(highestPaidByDept);

		highestPaidByDept.forEach((dept, emp) -> System.out.println(dept + ": " + emp.get().getName()));

		Map<Integer, Long> yearWiseCount = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getJoiningDate().getYear(), Collectors.counting()));

		System.out.println(yearWiseCount);

		List<Employee> employeesByName = employees.stream().sorted(Comparator.comparing(Employee::getName).reversed())
				.toList();

		System.out.println(employeesByName);

	}

}
