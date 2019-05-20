package com.naruto.day09.controller;

import com.naruto.day09.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void insertUser(){
        userService.insertUser();
    }

}
