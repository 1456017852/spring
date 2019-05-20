package com.naruto.day09.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @return
     */
    @Transactional
    public void insertUser(){
        String sql="INSERT INTO TB_USER (name,age) values (?,?)";
        jdbcTemplate.update(sql, UUID.randomUUID().toString().substring(0,5),19);
        int i=10/0;
    }

}
