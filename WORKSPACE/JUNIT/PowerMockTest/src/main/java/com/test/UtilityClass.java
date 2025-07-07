package com.test;

public class UtilityClass {

	public static int staticMethod(long value) {
		throw new RuntimeException("I don't want to be excuted. I will anywat be mocked out.");
//		return 0;
	}

}
