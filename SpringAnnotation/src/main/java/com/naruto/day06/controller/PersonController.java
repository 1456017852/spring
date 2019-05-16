package com.naruto.day06.controller;

import com.naruto.day06.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    /**
     *@Autowired 自动注入
     *
     * required：是否必须装配
     * required=true(默认):必须装配，容器中不存在该组件时，则报错
     * required=false:不必须装配，容器中不存在该组件时，不会注入
     *
     *@Qualifier:指定装配特定的bean
     *
     */
    //@Qualifier("personService2")
    @Autowired(required = true)
    private PersonService personService;

    public String printPersonFlag(){
        return personService.getFlag();
    }

    @Override
    public String toString() {
        return "PersonController{" +
                "personService=" + personService +
                '}';
    }
}
