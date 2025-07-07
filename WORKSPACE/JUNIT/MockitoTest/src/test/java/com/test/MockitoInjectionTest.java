package com.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.business.TodoBusinessImpl;
import com.test.service.TodoService;

@ExtendWith(MockitoExtension.class)
class MockitoInjectionTest {

	@Mock
	TodoService todoService;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	void test() {

		List<String> todos = Arrays.asList("Spring MVC", "Spring Boot", "Hibernate");

		when(todoService.retrieveTodos("Dummy")).thenReturn(todos);

		List<String> todosRelatedToSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, todosRelatedToSpring.size());

		List<String> list = Arrays.asList("Spring MVC", "Spring Boot");

		assertIterableEquals(list, todosRelatedToSpring);
	}

	@Test
	void testBDD() {

		List<String> todos = Arrays.asList("Spring MVC", "Spring Boot", "Hibernate");

		given(todoService.retrieveTodos("Dummy")).willReturn(todos);

		List<String> todosRelatedToSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertThat(todosRelatedToSpring.size(), is(2));

	}

	@Test
	void testDeleteBDD() {

		List<String> todos = Arrays.asList("Spring MVC", "Spring Boot", "Hibernate");

		given(todoService.retrieveTodos("Dummy")).willReturn(todos);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		verify(todoService).deleteTodo("Hibernate");
		then(todoService).should().deleteTodo("Hibernate");

		verify(todoService, times(1)).deleteTodo("Hibernate");
		then(todoService).should(times(1)).deleteTodo("Hibernate");

		verify(todoService, never()).deleteTodo("Spring MVC");
		then(todoService).should(never()).deleteTodo("Spring MVC");
	}

	@Test
	void testDeleteBDDCaptureArguments() {

		List<String> todos = Arrays.asList("Spring MVC", "Spring Boot", "Hibernate", "JPA");

		given(todoService.retrieveTodos("Dummy")).willReturn(todos);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

//		verify(todoService).deleteTodo("Hibernate");
		then(todoService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
	}

}