package com.naruto.day05.config;

import com.naruto.day05.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"classpath:/person.properties"})
@Configuration
@ComponentScan("com.naruto.day05")
public class BeanPropertyConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
