package com.therealdanvega.service;

import com.therealdanvega.domain.Todo;
import com.therealdanvega.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todo> list() {
        return todoRepository.findAll();
    }

    public Todo get(Long id){
        return todoRepository.findOne(id);
    }

    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo update(Long id, Todo todo){
        Todo updated = this.get(id);
        updated.setTitle(todo.getTitle());
        updated.setCompleted(todo.getCompleted());
        return todoRepository.save(updated);
    }

    public void delete(Long id){
        todoRepository.delete(id);
    }

}
