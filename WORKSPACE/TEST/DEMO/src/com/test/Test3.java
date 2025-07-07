package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {

	public static void main(String[] args) {

		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

		List<String> list = listOfStrings.stream().sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());

		System.out.println(list);
		
		String s1 = "Java";  
		s1.concat("Programming");
		System.out.println(s1);
	}

}
