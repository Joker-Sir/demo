package com.joker.demo.pojo;

import lombok.Data;

@Data
public class User {

    public User(Dog dog){

    }

    private Long id;

    private String username;

    private String nickname;

    private int age;

}
