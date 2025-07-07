package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test6 {

	public static void main(String[] args) {
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 2, 4, 6, 5);
//		
//		System.out.println(numbers);
//		
//		Collections.shuffle(numbers);
//		
//		System.out.println(numbers);

//		Map<Integer, Long> collect = numbers.stream()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//		System.out.println(collect);
//
//		long sum = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
//				.stream().filter(e -> e.getValue() > 1).mapToLong(Map.Entry::getValue).sum();
//
//		System.out.println(sum);
//
//		String str = "Java is a programming language";
//
//		String string = Arrays.stream(str.split(" ")).sorted(Comparator.comparing(String::length)).findFirst().get();
//
//		System.out.println(string);

		System.out.println(0.1 * 5 == 0.5);
		System.out.println(0.1 * 4 == 0.4);
		System.out.println(0.1 * 3 == 0.3);
		System.out.println(0.1 * 2 == 0.2);
	}

}
