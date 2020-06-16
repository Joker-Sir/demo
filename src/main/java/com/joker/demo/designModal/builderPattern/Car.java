package com.joker.demo.designModal.builderPattern;

import lombok.Builder;
import lombok.Data;

/**
 * { @link https://www.runoob.com/design-pattern/builder-pattern.html }
 * @Description 建造者模式
 * */
@Builder
@Data
public class Car {

    private String engine;

    private String tyre;

    private String dashboard;

    private String light;


}
