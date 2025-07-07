package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// Given a list of integers, write a program to find and print the second
		// largest number using Java Stream API.

//		List<Integer> numbers = Arrays.asList(3, 2, 1, 5, 6, 8, 5, 7);
//
//		Integer integer = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
//
//		System.out.println(integer);
//		
//		String aadharNo = "415125715262";
//		
//		aadharNo.replace(aadharNo.substring(8), *******);

//		Write a program to remove all non-numeric characters from a list of strings using Java Stream API.

//		List<String> list = Arrays.asList("a1b2c3", "1a2b3c", "123abc");
//
//		List<String> collect = list.stream().map(s -> s.replaceAll("[0-9]", "")).collect(Collectors.toList());
//
//		ArrayList<String> collect2 = list.stream().map(s -> s.replaceAll("[0-9]", ""))
//				.collect(Collectors.toCollection(ArrayList::new));
//
//		System.out.println(collect);
//
//		System.out.println(collect2);

		String str = "PANKAJ FENDRE";

		char[] chars = str.replaceAll(" ", "").toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars);
		System.out.println("Output: " + sorted);

		String collect2 = str.chars().mapToObj(c -> String.valueOf((char) c)).distinct()
				.sorted(Comparator.reverseOrder()).collect(Collectors.joining());

		System.out.println(collect2);

		Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(collect);
//		reversed = "RDF JKP"
//		output = "AENRDF JKP"

	}

}
