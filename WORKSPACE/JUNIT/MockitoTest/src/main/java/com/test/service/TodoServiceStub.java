package com.test.service;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Spring MVC", "Spring Boot", "Hibernate");
	}

	@Override
	public void deleteTodo(String todo) {
		System.out.println("DeleteTodo :: " + todo);
	}

}
