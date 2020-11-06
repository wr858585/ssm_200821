package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * @author oono
 * @date 2020 11 02
 */
public class SpringTest {

    ApplicationContext applicationContext;

    @Before
    public void setup(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test1(){
//        Object pojoBean = applicationContext.getBean("book");
//        Object bookDaoBean = applicationContext.getBean("bookDao");
//        Object bookServiceBean = applicationContext.getBean("bookService");
//        Object bookControllerBean = applicationContext.getBean("bookController");
//        System.out.println(pojoBean);
//        System.out.println(bookDaoBean);
//        System.out.println(bookServiceBean);
//        System.out.println(bookControllerBean);

//        Book book = new Book();
//        BookDao bookDao = new BookDao();

//        for (String name : applicationContext.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }

    }

    @Test
    public void test2(){
        //测试用了泛型之后，UserService里的baseDao，会注入什么值
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.saveEntity(new User());

    }



}
