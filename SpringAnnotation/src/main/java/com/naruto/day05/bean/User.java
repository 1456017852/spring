package com.naruto.day05.bean;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@PropertySource("classpath:/user.properties")
public class User {

    @Value("${user.is}")
    private String id;
    @Value("${user.age}")
    private String age;
    @Value("${user.name}")
    private String name;
}
