package com.joker.demo.justlook.note;

import com.joker.demo.pojo.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * 使用@Configuration 获取到的Dog对象是同一个(例如：Dog$$EnhancerBySpringCGLIB$$71cefds321@7517) 如果方式是首次被调用那么原始的方法体会被执行并且结果对象会被注册到Spring上下文中。
 * ConfigurationClassPostProcessor#postProcessBeanDefinitionRegistry
 * 使用@Component 获取到的Dog对象不同的 不会通过CGLIB增强
 *
 * */
// @Configuration
@Component
public class ConfigurationAnno {

    @Bean
    public Dog getDog(){
        Dog dog = new Dog();
        System.out.println("dog = " + dog.hashCode());
        return dog;
    }


}
