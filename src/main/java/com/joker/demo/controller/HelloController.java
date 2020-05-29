package com.joker.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "/sayHi/{name}" , method = RequestMethod.GET)
    public String sayHello(@PathVariable(name = "name")String name){
        return "hello " + name;
    }


}
