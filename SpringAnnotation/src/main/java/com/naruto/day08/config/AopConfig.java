package com.naruto.day08.config;

import com.naruto.day08.utils.LogAspects;
import com.naruto.day08.utils.MathUitls;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *配置类
 *
 */
@Configuration
@ComponentScan("com.naruto.day08")
@EnableAspectJAutoProxy//开启AOP注解
public class AopConfig {

}
