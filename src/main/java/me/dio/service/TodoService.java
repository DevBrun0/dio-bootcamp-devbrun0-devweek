package me.dio.service;

import me.dio.domain.model.TodoItem;
import me.dio.domain.model.User;

public interface TodoService {

    TodoItem findById(Long id);

    TodoItem create(TodoItem todoToCreate);
}
