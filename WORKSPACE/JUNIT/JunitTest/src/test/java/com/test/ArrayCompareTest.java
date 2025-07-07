package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class ArrayCompareTest {

	@Test
	void test() {
		int num[] = { 3, 2, 4, 1 };
		int exp[] = { 1, 2, 3, 4 };
		Arrays.sort(num);
		assertArrayEquals(exp, num);
	}

	@Test
	void testNullArray() {
		int num[] = null;
		assertThrows(NullPointerException.class, () -> {
			Arrays.sort(num);
		});
	}

	@Test
	@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
	void testTimeout() {
		long start = System.currentTimeMillis();
		int num[] = { 3, 2, 4, 1 };
		for (int i = 1; i < 1000000; i++) {
			num[0] = i;
			Arrays.sort(num);
		}
		System.out.println(System.currentTimeMillis() - start + " ms");
	}

}
