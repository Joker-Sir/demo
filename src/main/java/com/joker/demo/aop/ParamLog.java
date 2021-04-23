package com.joker.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ParamLog {


    @Pointcut("execution(* com.joker..*(..))")
    public void allCut(){}

    @Pointcut("execution(* com.joker.demo.websocket..*(..))")
    public void websocket(){}

    @Before("(!websocket()) && allCut()")
    public void outputParam(JoinPoint joinPoint){
        System.out.println("methodName = " + joinPoint.getSignature().getName());
        System.out.println("methodArgs = " + objectArray2String(joinPoint.getArgs()));
    }


    private static String objectArray2String(Object[] objects){
        String str = "";
        if (null == objects){
            return str;
        }
        for (Object object : objects) {
            str = str.concat(object.toString());
        }
        return str;
    }


}
