package me.dio.service;

import me.dio.domain.model.TodoItem;
import me.dio.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    public TodoItem findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public TodoItem save(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
