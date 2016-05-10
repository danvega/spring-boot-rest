package com.therealdanvega.controller;

import com.therealdanvega.domain.Todo;
import com.therealdanvega.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list")
    public Iterable<Todo> list(){
        return todoService.list();
    }

    @RequestMapping("/view/{id}")
    public Todo view(@PathVariable(value="id") Long id){
        return todoService.get(id);
    }

    @RequestMapping( value = "/create", method = RequestMethod.POST )
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @RequestMapping( value = "/update/{id}", method = RequestMethod.PUT )
    public Todo update(@PathVariable( value="id") Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable("id") Long id) {
        todoService.delete(id);
    }
}
