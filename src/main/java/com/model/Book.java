package com.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
public class Book {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private int amount;
//    @ManyToMany
//    @JoinTable(name="book_word",joinColumns = {@JoinColumn(name="b_id")},inverseJoinColumns = {@JoinColumn(name="w_id")})
//    private Set<Word> words;
}
