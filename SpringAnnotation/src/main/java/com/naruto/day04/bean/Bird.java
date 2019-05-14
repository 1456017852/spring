package com.naruto.day04.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bird {

    public Bird(){
        System.out.println("Bird创建");

    }

    /**
     * 对象创建并赋值好之后调用
     */
    @PostConstruct
    public void init(){
        System.out.println("Bird初始化...");
    }

    /**
     * 容器移除对象之前
     */
    @PreDestroy
    public void destory(){
        System.out.println("Bird销毁...");
    }
}
