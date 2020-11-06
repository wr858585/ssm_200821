package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.User;
import com.atguigu.service.BookService;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author oono
 * @date 2020 11 03
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringEnhancedTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @Test
    public void test(){
        userService.saveEntity(new User());
        System.out.println("====");
        bookService.saveEntity(new Book());
    }


}
