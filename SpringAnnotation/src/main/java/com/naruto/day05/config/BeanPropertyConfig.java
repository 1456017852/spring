package com.naruto.day05.config;

import com.naruto.day05.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class BeanPropertyConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
