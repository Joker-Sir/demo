package com.joker.demo.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class User {

    public User(Dog dog){

    }

    private Long id;

    private String username;

    private String nickname;

    private int age;

    List<MultipartFile> background;
    List<MultipartFile> avatar;


}
