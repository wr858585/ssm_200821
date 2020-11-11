package com.atguigu.service.impl;

import com.atguigu.mapper.BookMapper;
import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author oono
 * @date 2020 11 10
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public void saveBook(Book book) {
        bookMapper.insertSelective(book);
        //只是为了测试事务，测试完了记得删除
//        int i = 12/0;
//        bookMapper.insertSelective(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookMapper.selectByExample(null);
    }
}
