package com.therealdanvega.repository;

import com.therealdanvega.domain.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo,Long> {

    Todo findByTitle(String title);

    List<Todo> findByCompletedFalse();

}
