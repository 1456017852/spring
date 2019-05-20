package com.naruto.day09.service;

import com.naruto.day09.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void insertUser(){
        userDao.insertUser();
    }


}
