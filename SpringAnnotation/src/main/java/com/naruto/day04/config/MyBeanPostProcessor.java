package com.naruto.day04.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean后置处理器：bean初始化前后工作
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization---"+"【bean】:"+bean+"---【beanName】:"+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization---"+"【bean】:"+bean+"---【beanName】:"+beanName);
        return bean;
    }
}
