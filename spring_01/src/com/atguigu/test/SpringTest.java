package com.atguigu.test;

import com.atguigu.pojo.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author oono
 * @date 2020 10 31
 */
public class SpringTest {

    ApplicationContext applicationContext;

    @Before
    public void setup(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test1(){

        //在使用Spring的时候，需要现有spring容器|spring ioc容器|ioc 容器对象
        //运用接口ApplicationContext中的classpathXmlApplicationContext实现类
        //表示从类路径（src）中加载xml配置文件new出Spring容器对象

        //用getBean()从容器中获取指定的bean对象
        Person p1 = (Person)applicationContext.getBean("p1");

        System.out.println(p1);
    }

    @Test
    public void test2(){
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
        //由于有两个为Person类的beans，所以用会报错
    }

    @Test
    public void test3(){
        Person p3 = (Person)applicationContext.getBean("p3");
        System.out.println(p3);
    }

    @Test
    public void test4(){
        Person p4 = (Person)applicationContext.getBean("p4");
        System.out.println(p4);
    }

    @Test
    public void test5(){
        Person p5 = (Person)applicationContext.getBean("p5");
        System.out.println(p5);
    }

}
