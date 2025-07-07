package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "A", "B", "C", "A", "B", "C", "D", "D", "D");

		Map<String, Long> collect = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(collect);

		Map<String, Integer> collect2 = list.stream()
				.collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));

		System.out.println(collect2);
	}
}
