package me.dio.controller;

import me.dio.domain.model.TodoItem;
import me.dio.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public TodoItem getTodoById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    public TodoItem createTodo(@RequestBody TodoItem todoItem) {
        return todoService.save(todoItem);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodo(@PathVariable Long id, @RequestBody TodoItem todoItem) {
        TodoItem existingTodo = todoService.findById(id);
        if (existingTodo != null) {
            existingTodo.setDescription(todoItem.getDescription());
            existingTodo.setCompleted(todoItem.isCompleted());
            return todoService.save(existingTodo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteById(id);
    }
}
