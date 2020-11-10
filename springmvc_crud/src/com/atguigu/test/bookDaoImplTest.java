package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 11 09
 */

@ContextConfiguration("classpath:springmvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class bookDaoImplTest {

    @Autowired
    BookDao bookDao;

    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null,1,1,"test2","oono",new BigDecimal("1")));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22,12,1,"test2","oono",new BigDecimal("1")));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        bookDao.queryBooks().forEach(System.out::println);
    }
}