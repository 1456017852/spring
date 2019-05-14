package com.naruto.day04.config;

import com.naruto.day04.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.naruto.day04")
public class BeanLifeCycleConfig {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }



}
