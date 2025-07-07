package com.test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestExample2 {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 4, 5, 6, 3, 5, 2, 5 };

		// print each number with its occurence

		List<Integer> list = Stream.of(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).toList();

		System.out.println(list);

	}
}
