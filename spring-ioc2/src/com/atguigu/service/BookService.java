package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author oono
 * @date 2020 11 02
 */

/**
 * @Service注解相当于在applicationContext.xml文件中写了一个bean对象：
 * "<bean class="com.atguigu.service.BookService" id="bookService"></bean>
 */
@Service
//@Scope("prototype")
public class BookService extends BaseService<Book> {

    /**
     * @Autowired注解会让Spring容器自动的到Spring容器中查找相应的对象，给其赋值
     * 1. 先会到Spring容器中，按照对象的类型去查找。找到一个就直接赋值
     * 2. 如果找到多个同样类型的，会按照变量名去找作为id去赋值
     * 3. 如果还是找不到唯一的（比如变量名我写的是自己定义的一个非类名的名字），则可以使用@Qualifier注解告诉是哪个
     */


    @Autowired(required = false)
    public void abc(@Qualifier("bookDao") BookDao bookDao1){
        System.out.println("bookDao --> " + bookDao1);
        System.out.println("abc方法被调用了");
    }

//    @Override
//    public String toString() {
//        return "BookService{" +
//                "bookDao=" + myCustomizedVariableName +
//                '}';
//    }
}
