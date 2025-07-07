package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestExample1 {

	public static void main(String[] args) {
		String str = "Capgemini";

		Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);

		List<Integer> list1 = Arrays.asList(10, 20, 50, 25, 30, 40, 20);

		List<Integer> list2 = Arrays.asList(12, 14, 20, 25, 60, 70);

		List<Integer> list = Stream.concat(list1.stream(), list2.stream()).sorted().distinct().toList();

		System.out.println(list);
	}

}
