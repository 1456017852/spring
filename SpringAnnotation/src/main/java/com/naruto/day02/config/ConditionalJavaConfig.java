package com.naruto.day02.config;

import com.naruto.day02.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalJavaConfig {

    @Conditional({WindowsConditionalBean.class})
    @Bean
    public User user(){
        return new User();
    }

    @Conditional({LinuxConditionalBean.class})
    @Bean
    public User user1(){
        return new User();
    }

}
