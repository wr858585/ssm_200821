package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author oono
 * @date 2020 11 10
 */

@RequestMapping(value = "/book")
@Controller
public class BookController {

    @Autowired
    BookService bookService;

//    public String list(){
//        List<Book> books = bookService.queryBooks();
//    }


}
