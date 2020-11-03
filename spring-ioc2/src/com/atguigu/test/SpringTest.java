package com.atguigu.test;

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
        Object pojoBean = applicationContext.getBean("book");
        Object bookDaoBean = applicationContext.getBean("bookDao");
        Object bookServiceBean = applicationContext.getBean("bookService");
        Object bookControllerBean = applicationContext.getBean("bookController");
        System.out.println(pojoBean);
        System.out.println(bookDaoBean);
        System.out.println(bookServiceBean);
        System.out.println(bookControllerBean);
    }

}
