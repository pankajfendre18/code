package com.test.business;

import java.util.ArrayList;
import java.util.List;

import com.test.service.TodoService;

public class TodoBusinessImpl {

	private TodoService service;

	public TodoBusinessImpl(TodoService service) {
		this.service = service;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<>();
		List<String> todos = service.retrieveTodos(user);
		for (String todo : todos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> todos = service.retrieveTodos(user);
		for (String todo : todos) {
			if (!todo.contains("Spring")) {
				service.deleteTodo(todo);
			}
		}
	}

}
