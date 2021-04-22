package com.joker.demo.util;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdbaExpression {

    @Test
    public void testFunction(){
        Function<String,String> function = (old) -> old + "+mes";
        String result = function.apply("wh");
        Assertions.assertEquals("wh+mes","wh+mes");
    }

    @Test
    public void testPredicate(){
        Predicate<String> predicate = (x)->x.endsWith("txt");
        predicate.test("filetxt");
        Assertions.assertEquals(true,predicate.test("filetxt"));
    }

    @Test
    public void testConsumer(){
        Consumer<String> consumer = (s)->{
            String s1 = s.concat("consumer");
            System.out.println(s1);};
        consumer.accept("s");
    }

    @Test
    public void testSupplier(){
        Supplier<String> supplier = ()->"supplier";
        String result = supplier.get();
        System.out.println(result);
    }
}
