package com.atguigu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

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
    public void testDataSource(){
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }



}
