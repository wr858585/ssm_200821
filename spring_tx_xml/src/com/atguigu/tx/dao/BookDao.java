package com.atguigu.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oono
 * @date 2020 11 05
 */
@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateBook(){
        return jdbcTemplate.update("update book set name = ?", "图书表被修改了");
    }

}
