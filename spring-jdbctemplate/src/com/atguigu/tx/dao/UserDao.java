package com.atguigu.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author oono
 * @date 2020 11 05
 */
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int updateUser(){
        return jdbcTemplate.update("update user set username = ?", "用户表被修改");
    }

}
