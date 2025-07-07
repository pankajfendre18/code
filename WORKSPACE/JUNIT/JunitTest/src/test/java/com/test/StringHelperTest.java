package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringHelperTest {

	StringHelper stringHelper;

	@BeforeEach
	void before() {
		stringHelper = new StringHelper();
	}

	@Test
	void testTruncateAInFirst2Positions() {
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
	}

	@Test
	void testTruncateAInFirst2Positions1() {
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
	}

	@Test
	void testAreFirstAndLastTwoCharactersTheSame() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@Test
	void testAreFirstAndLastTwoCharactersTheSame1() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
}
