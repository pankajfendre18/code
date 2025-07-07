package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SpyTest {

	@Test
	void test() {
		List listSpy = spy(ArrayList.class);
		assertEquals(0, listSpy.size());
		listSpy.add("PANKAJ");
		verify(listSpy).add("PANKAJ");
		assertEquals(1, listSpy.size());
		listSpy.remove("PANKAJ");
		assertEquals(0, listSpy.size());

	}

}
