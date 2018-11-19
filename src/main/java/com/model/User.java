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
    private int dayNum;
    @Column
    private String openid;

    public User(String name, int dayNum,String openid) {
        this.name = name;
        this.dayNum = dayNum;
        this.openid = openid;
    }

    public User(String name, String openid) {
        this.name = name;
        this.dayNum = 50;
        this.openid = openid;
    }
}
