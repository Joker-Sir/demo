package com.joker.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckNull {

    @Before(value = "@annotation(com.joker.demo.annotation.NotNullCheck)")
    public void checkParam(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg = " + arg);
        }

    }



}
