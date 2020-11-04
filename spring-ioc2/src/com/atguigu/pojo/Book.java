package com.atguigu.pojo;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author oono
 * @date 2020 11 02
 */

/**
 * @component注解的作用，相当在applicationContext.xml文件里写了一个bean对象：
 * <bean class="com.atguigu.pojo.Book" id="book"/>
 */
@Component
public class Book {


}
