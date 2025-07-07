package com.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickBeforeAfterTest {

	@BeforeAll
	static void beforeClass() {
		System.out.println("Before Class");
	}

	@BeforeEach
	void before() {
		System.out.println("Before Test");
	}

	@Test
	void test1() {
		System.out.println("Test1");
	}

	@Test
	void test2() {
		System.out.println("Test2");
	}

	@AfterEach
	void after() {
		System.out.println("After Test");
	}

	@AfterAll
	static void afterClass() {
		System.out.println("After Class");
	}

}
