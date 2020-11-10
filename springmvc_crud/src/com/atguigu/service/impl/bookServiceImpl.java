package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author oono
 * @date 2020 11 09
 */

@Service
public class bookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        Book book = bookDao.queryBookById(id);
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        List<Book> books = bookDao.queryBooks();
        return books;
    }
}
