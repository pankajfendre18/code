package com.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListTest {

	@Test
	void testListSize() {
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(2);
		assertEquals(2, list.size());
	}

	@Test
	void testListSize1() {
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, list.size());
		assertEquals(3, list.size());
	}

	@Test
	void testListGet() {
		List list = mock(List.class);
		given(list.get(anyInt())).willReturn(0);
		assertEquals(0, list.get(0));
		assertEquals(0, list.get(1));
	}
	
	@Test
	void testListGetBDD() {
		List list = mock(List.class);
		when(list.get(anyInt())).thenReturn(0);
		
		assertThat(list.get(0), is(0));
	}

	@Test
	void testListGetException() {
		List<?> list = mock(List.class);
		when(list.get(anyInt())).thenThrow(new RuntimeException());

		assertThrows(RuntimeException.class, () -> list.get(0));
	}
}
