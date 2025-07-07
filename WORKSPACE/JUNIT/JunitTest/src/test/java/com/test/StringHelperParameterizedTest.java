package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class StringHelperParameterizedTest {

	StringHelper stringHelper;

	@BeforeEach
	void before() {
		stringHelper = new StringHelper();
	}

	static Stream<String[]> testConditions() {
		String expectedOuptput[][] = { { "AACD", "CD" }, { "ACD", "CD" } };
		return Stream.of(expectedOuptput);
	}

	@ParameterizedTest
//	@CsvSource({ "AACD, CD", "ACD, CD" })
	@MethodSource("testConditions")
	void testTruncateAInFirst2Positions(String input, String output) {
		assertEquals(output, stringHelper.truncateAInFirst2Positions(input));
	}

}