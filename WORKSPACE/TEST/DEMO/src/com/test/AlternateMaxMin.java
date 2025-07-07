package com.test;

import java.util.Arrays;

public class AlternateMaxMin {

	public static void rearrange(int[] arr) {
		Arrays.sort(arr); // Sort the array

		int[] result = new int[arr.length];
		int start = 0, end = arr.length - 1;
		boolean pickMax = true;

		for (int i = 0; i < arr.length; i++) {
			if (pickMax) {
				result[i] = arr[end--];
			} else {
				result[i] = arr[start++];
			}
			pickMax = !pickMax;
		}

		// Copy result back to original array
		System.arraycopy(result, 0, arr, 0, arr.length);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 8, 7, 6 };
		rearrange(arr);
		System.out.println("Rearranged array: " + Arrays.toString(arr));
	}

}
