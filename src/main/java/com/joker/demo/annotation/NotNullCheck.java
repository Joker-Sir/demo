package com.joker.demo.annotation;


import java.lang.annotation.*;

@Target(value = {ElementType.FIELD, ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNullCheck {

    boolean nullable() default false;

}
