package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SwitchExample {
	public static void main(String[] args) {

//		int day = 10;
//		String result = switch (day) {
//		case 1, 2, 3, 4, 5 -> "Weekday";
//		case 6, 7 -> "Weekend";
//		default -> "Invalid";
//		};
//
//		System.out.println(result);
//
//		String json = """
//				 {
//				 "name": "Pankaj",
//				 "role": "Engineer"
//				 }
//				 """;
//		System.out.println(json);

		List<Integer> list = Arrays.asList(101, 102, 203, 101);

		List<Integer> list1 = list.stream().filter(num -> String.valueOf(num).startsWith("1")).toList();

		System.out.println(list1);

		Map<Integer, Long> frequencyMap = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(frequencyMap);

		Optional<Integer> max = list.stream().max(Integer::compare);
		System.out.println(max.get());

	}
}
