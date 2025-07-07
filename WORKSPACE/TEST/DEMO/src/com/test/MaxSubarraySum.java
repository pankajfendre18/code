package com.test;

import java.util.Arrays;

public class MaxSubarraySum {

	public static int[] maxSubArray(int[] nums) {
		int maxSoFar = nums[0];
		int currentMax = nums[0];
		int start = 0, end = 0, tempStart = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > currentMax + nums[i]) {
				currentMax = nums[i];
				tempStart = i;
			} else {
				currentMax += nums[i];
			}

			if (currentMax > maxSoFar) {
				maxSoFar = currentMax;
				start = tempStart;
				end = i;
			}
		}

		return Arrays.copyOfRange(nums, start, end + 1);
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] subarray = maxSubArray(nums);

		System.out.println("Maximum subarray is: " + Arrays.toString(subarray));
		int sum = Arrays.stream(subarray).sum();
		System.out.println("Maximum subarray sum is: " + sum);
	}

}
