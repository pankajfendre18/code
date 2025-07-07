package com.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class StringHelperParameterizedTest1 {

	StringHelper stringHelper;

	@BeforeEach
	void before() {
		stringHelper = new StringHelper();
	}

	static Stream<String> testConditions() {
		String expectedOuptput[] = { "ABCD", "ABAA" };
		return Stream.of(expectedOuptput);
	}

	@ParameterizedTest
//	@CsvSource({ "ABCD", "ABAA" })
	@MethodSource("testConditions")
	void testTruncateAInFirst2Positions(String input) {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame(input));
	}

}