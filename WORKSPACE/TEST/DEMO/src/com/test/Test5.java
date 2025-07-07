package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test5 {
	public static void main(String[] args) {

//		int a = 5;
//		int b = 10;
//		System.out.println("a = " + a + ", b = " + b);
//		
//		a = a ^ b;
//		System.out.println(a);
//		b = a ^ b;
//		System.out.println(b);
//		a = a ^ b;
//		System.out.println(a);
//
//		System.out.println("a = " + a + ", b = " + b);

//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//		List<Integer> collect = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
//
//		System.out.println(collect);

		List<String> c1 = new LinkedList<String>();
		c1.add("Red");
		c1.add("Green");
		c1.add("Black");
		c1.add("White");
		c1.add("Pink");

		List<String> c2 = new LinkedList<String>();
		c2.add("Red");
		c2.add("Green");
		c2.add("Black");
		c2.add("Orange");

		Set<String> unique = Stream.concat(c1.stream(), c2.stream()).filter(e -> !(c1.contains(e) && c2.contains(e)))
				.collect(Collectors.toSet());

		System.out.println(unique);

		char[] chars = { 'a', 'b', 'c', 'a', 'b', 'a' };

		Map<Character, Long> charCount = IntStream.range(0, chars.length).mapToObj(i -> chars[i])
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("Character frequencies: " + charCount);

	}
}
