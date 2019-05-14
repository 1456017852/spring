package com.naruto.day03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Import({ Yellow.class, Green.class,MyImportSeleter.class,MyImportBeanDefinitionRegistrar.class}) //导入组件
public class ImportJavaConfig {

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
