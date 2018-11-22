package com.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
public class Word {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String IPA;
    @Column
    private String meaning;
//    @ManyToMany
//    @JoinTable(name="book_word",joinColumns = {@JoinColumn(name="w_id")},inverseJoinColumns = {@JoinColumn(name="b_id")})
//    private Set<Book> books;

    public Word(int id, String name, String IPA, String means) {
        this.id = id;
        this.name = name;
        this.IPA = IPA;
        this.meaning = means;
    }

    public Word(String name, String IPA, String means) {
        this.name = name;
        this.IPA = IPA;
        this.meaning = means;
    }
}
