package com.atguigu.service;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author oono
 * @date 2020 11 10
 */
public interface BookService {

    void saveBook(Book book);

    void updateBook(Book book);

    void deleteBook(Integer id);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

}
