package com.naruto.day04.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {


    public Cat(){
        System.out.println("cat创建...");
    }

    //初始化方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat初始化...");
    }

    //销毁方法
    public void destroy() throws Exception {
        System.out.println("cat销毁...");

    }


}
