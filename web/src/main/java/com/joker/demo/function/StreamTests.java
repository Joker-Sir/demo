package com.joker.demo.function;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream相关操作
 * <a href="https://juejin.cn/post/6983835171145383967">stream博文</a>
 * mvn clean install -e -U -Dmaven.test.skip=true
 * */
public class StreamTests {

    @Data
    static class OrderVo{
        String orderNo;
        List<String> items;
    }

    static OrderVo orderVo1 = new OrderVo();
    static OrderVo orderVo2 = new OrderVo();

    static void data(){
        orderVo1.setOrderNo("1101");
        orderVo2.setOrderNo("1102");
        orderVo1.setItems(new ArrayList<String>(){{add("123");add("124");add("125");}});
        orderVo2.setItems(new ArrayList<String>(){{add("223");add("224");add("225");}});
    }

    public static void main(String[] args) {
        data();
        Stream<OrderVo> orderVo = Stream.of(orderVo1, orderVo2);

        // orderVo.forEach(t -> System.out.println(t.getItems()));

        //平展成一个新的stream
        Stream<String> stringStream = orderVo.flatMap(t -> t.getItems().stream());
        stringStream.forEach(t -> System.out.println(t));






    }



}
