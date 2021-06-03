package com.joker.demo.service.impl;

import com.joker.demo.mapper.UserMapper;
import com.joker.demo.pojo.User;
import com.joker.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAllUsers(){
        return userMapper.allUsers();
    }

}
