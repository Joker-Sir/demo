package com.joker.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joker.demo.pojo.User;
import com.joker.demo.service.UserService;
import com.joker.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hello")
@PropertySource("classpath:exam.properties")
@Slf4j
public class HelloController {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private UserService userService;

    @Value("${welcome}")
    private String welcome;

    @Autowired
    private ApplicationContext context;

    @Autowired
    HelloController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/sayHi/{name}" , method = RequestMethod.GET)
    public String sayHello(@PathVariable(name = "name")String name){
        return welcome + " hello " + name;
    }

    @RequestMapping(value = "/findAllUsers" , method = RequestMethod.GET)
    public String findAllUsers() throws Exception{
        // List<User> allUsers = userService.findAllUsers();
        UserServiceImpl service = (UserServiceImpl)context.getBean("userServiceImpl");
        List<User> allUsers = service.findAllUsers();
        String result = objectMapper.writeValueAsString(allUsers);
        return result;
    }


}
