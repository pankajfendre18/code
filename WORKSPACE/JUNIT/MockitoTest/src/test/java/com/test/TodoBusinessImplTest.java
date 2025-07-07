package com.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.test.business.TodoBusinessImpl;
import com.test.service.TodoService;

class TodoBusinessImplTest {

	@Test
	void test() {
		TodoService todoService = mock(TodoService.class);

		List<String> todos = Arrays.asList("Spring MVC", "Spring Boot", "Hibernate");

		when(todoService.retrieveTodos("Dummy")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		List<String> todosRelatedToSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, todosRelatedToSpring.size());

		List<String> list = Arrays.asList("Spring MVC", "Spring Boot");

		assertIterableEquals(list, todosRelatedToSpring);
	}

	@Test
	void testBDD() {
		TodoService todoService = mock(TodoService.class);

		List<String> todos = Arrays.asList("Spring MVC", "Spring Boot", "Hibernate");

		given(todoService.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		List<String> todosRelatedToSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertThat(todosRelatedToSpring.size(), is(2));

	}

	@Test
	void testDeleteBDD() {
		TodoService todoService = mock(TodoService.class);

		List<String> todos = Arrays.asList("Spring MVC", "Spring Boot", "Hibernate");

		given(todoService.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

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

		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		TodoService todoService = mock(TodoService.class);

		List<String> todos = Arrays.asList("Spring MVC", "Spring Boot", "Hibernate", "JPA");

		given(todoService.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

//		verify(todoService).deleteTodo("Hibernate");
		then(todoService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
	}
}
