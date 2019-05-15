package com.naruto.day05.bean;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Person {

    @Value("1")
    private String id;
    @Value("${person.name}") //@PropertySource
    private String name;
    @Value("#{20-2}")
    private String age;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
