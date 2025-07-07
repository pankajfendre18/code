package com.test;

public class TestEmployee {

	public static void main(String[] args) {
		Employee emp = new Employee();
		Employee emp1 = emp;
		emp = null;
		emp1.setName("PANKAJ");
		System.out.println(emp1.getName());

		Runtime runtime = Runtime.getRuntime();
		System.out.println("available Processor " + runtime.availableProcessors());

		long maxMemory = runtime.maxMemory();
		long totalMemory = runtime.totalMemory();
		long freeMemory = runtime.freeMemory();
		System.out.println("total Memmory " + totalMemory);
		System.out.println("free Memmory " + freeMemory);
		System.out.println("Max Memmory " + maxMemory);
		System.out.println(totalMemory + freeMemory);
	}

}
