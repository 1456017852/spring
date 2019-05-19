package com.naruto.day08.utils;

import org.springframework.stereotype.Component;

/**
 * 业务逻辑类
 */
@Component
public class MathUitls {

    /**
     * 乘法
     * @param i
     * @param j
     * @return
     */
    public int mul(int i,int j){
        System.out.println("mul....");
        return i*j;
    }

    /**
     * 除法
     * @param i
     * @param j
     * @return
     */
    public float div(int i,int j){
        System.out.println("div....");
     return i/j;
    }




}
