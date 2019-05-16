package com.naruto.day06.service;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private String flag="1";

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
