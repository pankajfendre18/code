package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test4 {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 4, 6, 7, 3);

		Set<Integer> set = new HashSet<>(list);

		System.out.println(set);

		Integer arr[] = new Integer[] { 1, 2, 3, 4, 5, 6, 8, 4, 6, 7, 3 };

		List<Integer> list1 = Arrays.asList(arr);

		System.out.println(list1);

	}
}
