package com.atguigu.service;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author oono
 * @date 2020 11 09
 */
public interface BookService {

    void saveBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

}
