package com.atguigu.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author oono
 * @date 2020 11 05
 */
@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int updateBook(){
        return jdbcTemplate.update("update book set name = ?", "图书表被修改了");
    }

}
