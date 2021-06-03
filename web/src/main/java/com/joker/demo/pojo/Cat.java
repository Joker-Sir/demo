package com.joker.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Cat {


    @NotNull(message = "猫名不能为空")
    @NotEmpty(message = "猫名不能为空")
    private String name;

    @NotNull(message = "颜色不能为空")
    @NotEmpty(message = "颜色不能为空")
    private String color;

    @NotNull(message = "猫龄不能为空")
    @NotEmpty(message = "猫龄不能为空")
    private String age;




}
