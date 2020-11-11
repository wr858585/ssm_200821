package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 11 10
 */

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void saveBook() {
        bookService.saveBook(new Book(null,"把班主任,拉出去糟蹋了",
                "SZ王灿侨", new BigDecimal(1000), 10000,10000));
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"改测试","oono",new BigDecimal(1000),10000,100));
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(23);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(20));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }
}