package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author oono
 * @date 2020 11 09
 */
public interface BookDao {

    int saveBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

}
