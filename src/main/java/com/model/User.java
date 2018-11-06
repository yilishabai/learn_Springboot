package com.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
