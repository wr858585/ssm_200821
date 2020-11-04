package com.atguigu.dao;

import com.atguigu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author oono
 * @date 2020 11 02
 */

/**
 * @Repository注解的作用，相当于在applicationContext.xml文件中写个一个bean对象：
 * <bean class="com.atguigu.dao.BookDao" id="bookDao"/>
 */

@Repository
public class BookDao extends BaseDao<Book>{

    @Override
    public void saveEntity(Book entity) {
        System.out.println("BookDao保存：" + entity);
    }
}
