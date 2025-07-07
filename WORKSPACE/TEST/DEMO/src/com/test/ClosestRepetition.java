package com.test;

import java.util.*;

public class ClosestRepetition {
	public static int findClosestRepetition(int[] nums) {
		Map<Integer, Integer> lastSeen = new HashMap<>();
		int minDistance = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (lastSeen.containsKey(nums[i])) {
				int distance = i - lastSeen.get(nums[i]);
				minDistance = Math.min(minDistance, distance);
			}
			lastSeen.put(nums[i], i);
		}

		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}

	public static void main(String[] args) {
		int[][] testCases = { { 1, 2, 3, 4, 1, 9 }, { 1, 0, 0, 1, 2, 3, 2, 3 }, { 1, 4, 7, 8 } };

		for (int i = 0; i < testCases.length; i++) {
			int result = findClosestRepetition(testCases[i]);
			System.out.println("Test case " + (i + 1) + " result: " + result);
		}
	}
}
