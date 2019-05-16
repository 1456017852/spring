package com.naruto.day06.controller;

import com.naruto.day06.service.StudentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.inject.Inject;

@Controller
public class StudentController {

    //@Resource(name="studentService2")
    @Inject
    private StudentService studentService;

    @Override
    public String toString() {
        return "StudentController{" +
                "studentService=" + studentService +
                '}';
    }
}
