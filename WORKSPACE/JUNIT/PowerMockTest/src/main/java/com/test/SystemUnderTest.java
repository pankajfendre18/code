package com.test;

import java.util.ArrayList;
import java.util.List;

interface Dependency {
	List<Integer> retrieveAllStats();
}

public class SystemUnderTest {

	private Dependency dependency;

	public int methodUsingAnArrayListConstructor() {
		ArrayList arrayList = new ArrayList<>();
		return arrayList.size();
	}

	public int methodCallingAStaticMethod() {
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for (Integer integer : stats) {
			sum += integer;
		}
		return UtilityClass.staticMethod(sum);
	}

	private long privateMethodUnderTest() {
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for (Integer integer : stats) {
			sum += integer;
		}
		return sum;
	}
}
