package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockingStaticMethodTest {

	@Mock
	Dependency dependency;

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	void test() {

		List<Integer> list = List.of(1, 2, 3, 4, 5);

		when(dependency.retrieveAllStats()).thenReturn(list);

		try (MockedStatic<UtilityClass> mockedStatic = mockStatic(UtilityClass.class)) {
			mockedStatic.when(() -> UtilityClass.staticMethod(0)).thenReturn(10);

			int result = systemUnderTest.methodCallingAStaticMethod();

			assertEquals(10, result);

			mockedStatic.verify(() -> UtilityClass.staticMethod(0));
		}

	}

}