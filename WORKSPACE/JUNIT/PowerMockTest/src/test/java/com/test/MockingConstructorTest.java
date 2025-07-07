package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockingConstructorTest {

	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	void test() throws Exception {

		try (MockedConstruction<ArrayList> mockedList = Mockito.mockConstruction(ArrayList.class, (mock, context) -> {
			Mockito.when(mock.size()).thenReturn(1);
		})) {
			int size = systemUnderTest.methodUsingAnArrayListConstructor();
			assertEquals(1, size);
		}

	}

}