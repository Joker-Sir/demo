package com.joker.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joker.demo.annotation.NotNullCheck;
import com.joker.demo.eventlistener.simple.event.SmsEvent;
import com.joker.demo.justlook.note.ConfigurationAnno;
import com.joker.demo.pojo.Dog;
import com.joker.demo.pojo.User;
import com.joker.demo.service.NotifierService;
import com.joker.demo.service.SmsService;
import com.joker.demo.service.UserService;
import com.joker.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("hello")
@PropertySource("classpath:exam.properties")
@Slf4j
public class HelloController {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private UserService userService;
    private SmsService smsService;
    private NotifierService notifierService;

    @Value("${welcome}")
    private String welcome;

    @Autowired
    private ApplicationContext context;

    @Autowired
    ConfigurationAnno anno;

    @Autowired
    HelloController(UserService userService, SmsService smsService, NotifierService notifierService){
        this.userService = userService;
        this.smsService = smsService;
        this.notifierService = notifierService;
    }

    @RequestMapping(value = "/sayHi/{name}" , method = RequestMethod.GET)
    @NotNullCheck
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

    @RequestMapping(value = "sendSms", method = RequestMethod.GET)
    public String sendSms(String telephone){
        smsService.sendSms(telephone);
        System.out.println("信息已返回");
        return "发送成功";
    }


    @RequestMapping(value = "notify", method = RequestMethod.GET)
    public String notify(String content){
        System.out.println("anno.getDog().hashCode()1 ==----=-==== " + anno.getDog() + "  " + anno.getDog().hashCode());
        System.out.println("anno.getDog().hashCode()2 ==----=-==== " + anno.getDog() + "  " + anno.getDog().hashCode());
        notifierService.notify(content);
        return "发送成功";
    }


}
