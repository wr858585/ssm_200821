package com.atguigu.controller;

import com.atguigu.mapper.BookMapper;
import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * @author oono
 * @date 2020 11 10
 */

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(path = "/save")
    public String save(Book book){
        bookService.saveBook(book);
        return "redirect:/index.jsp";
    }

}
