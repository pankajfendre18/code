package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockingPrivateMethodTest {

	@Mock
	Dependency dependency;

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	void test() throws Exception {

		List<Integer> mockStats = List.of(1, 2, 3);
		Mockito.when(dependency.retrieveAllStats()).thenReturn(mockStats);

		Method privateMethod = SystemUnderTest.class.getDeclaredMethod("privateMethodUnderTest");
		privateMethod.setAccessible(true);
		long result = (long) privateMethod.invoke(privateMethod);

		assertEquals(6, result);
	}

}