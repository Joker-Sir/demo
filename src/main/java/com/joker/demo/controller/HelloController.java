package com.joker.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joker.demo.pojo.User;
import com.joker.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private UserService userService;

    @Autowired
    HelloController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/sayHi/{name}" , method = RequestMethod.GET)
    public String sayHello(@PathVariable(name = "name")String name){
        return "hello " + name;
    }

    @RequestMapping(value = "/findAllUsers" , method = RequestMethod.GET)
    public String findAllUsers() throws Exception{
        List<User> allUsers = userService.findAllUsers();
        String result = objectMapper.writeValueAsString(allUsers);
        return result;
    }

}
