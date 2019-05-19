package com.naruto.day08.config;

import com.naruto.day08.utils.LogAspects;
import com.naruto.day08.utils.MathUitls;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 */
@Configuration
@EnableAspectJAutoProxy//开启AOP
public class AopConfig {

    @Bean
    public MathUitls mathUitls(){
        return new MathUitls();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }


}
