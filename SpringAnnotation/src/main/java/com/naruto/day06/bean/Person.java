package com.naruto.day06.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Person implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public ApplicationContext getApplicationContext(){
        return applicationContext;
    }

}
