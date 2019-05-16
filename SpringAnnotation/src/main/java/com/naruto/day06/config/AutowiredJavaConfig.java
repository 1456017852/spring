package com.naruto.day06.config;

import com.naruto.day06.service.PersonService;
import com.naruto.day06.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.naruto.day06")
public class AutowiredJavaConfig {

    //@Primary
    @Bean(name = "personService2")
    public PersonService personService(){
        PersonService personService=new PersonService();
        personService.setFlag("2");
        return personService;
    }

    @Bean("studentService2")
    public StudentService studentService(){
        return new StudentService();
    }


}
