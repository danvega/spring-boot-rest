package com.therealdanvega.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Todo {

    @Id @GeneratedValue
    Long id;
    String title;
    Boolean completed;

    private Todo(){}

    // getters and setters

}
