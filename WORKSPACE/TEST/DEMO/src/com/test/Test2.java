package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {
	public static void main(String[] args) {

		List<String> list = Arrays.asList("TEU", "XYZ", "PEE", "XYZ", "WER");

		long count = list.stream().map(String::toUpperCase).mapToLong(s -> s.chars().filter(ch -> ch == 'E').count())
				.sum();

		System.out.println(count);

		Map<String, Integer> map1 = new LinkedHashMap<>();
		map1.put("AKSHAY", 10000);
		map1.put("PANKAJ", 20000);
		map1.put("KUNAL", 30000);

		Map<String, Integer> map2 = new LinkedHashMap<>();
		map2.put("PRASHANT", 10000);
		map2.put("PANKAJ", 20000);
		map2.put("ABHISHEK", 30000);

		
//		for (Map.Entry<String, Integer> entry : map2.entrySet()) {
//			map1.merge(entry.getKey(), entry.getValue(), Integer::sum);
//		}

		System.out.println(map1);

		map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));

		System.out.println(map1);

		List<String> list1 = Arrays.asList("QWE", "XYZ", "ERT", "ABC", "DEF");

		Set<String> set = new HashSet<>();

		List<String> list2 = list.stream().filter(s -> !set.add(s)).collect(Collectors.toList());

		System.out.println(list2);

		List<String> list3 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println(list3);

		List<String> list4 = list.stream().filter(s -> list1.contains(s)).collect(Collectors.toList());

		System.out.println(list4);
		
	}
}
