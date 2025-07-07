package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FunctionalInterface
interface DuplicateRemover {
	List<Integer> removeDuplicates(List<Integer> list);
}

public class Test {
	public static void main(String[] args) {
		List<String> input = Arrays.asList("cat", "dog", "elephant", "giraffe");

		Map<Integer, List<String>> result = input.stream().collect(Collectors.groupingBy(String::length));

		System.out.println(result);

		List<Integer> input1 = Arrays.asList(1, 2, 3, 3, 4, 2, 5);

		// Lambda expression implementing the functional interface
		DuplicateRemover remover = list -> list.stream().distinct().toList();

		List<Integer> result1 = remover.removeDuplicates(input1);
		System.out.println(result1);
	}
}
