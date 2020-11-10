package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author oono
 * @date 2020 11 09
 */

@Controller
public class RestController {

    /**
     * @RequestMapping(value = "/book/{id}, method = RequestMethod.GET)
     * 其中，value = "/book/{id}"地址中的{参数名}我们管他叫路径参数，是一个变量
     * @PathVariable("id") Integer id表示获取路径参数id的值，作为实参赋给方法中的Integer id形参使用!妙不妙！
     * @return
     */
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String queryBookById(@PathVariable("id") Integer id){
        System.out.println("查询id=1的图书");
        return "redirect:/index.jsp";
    }

    @RequestMapping(path = "/book", method = RequestMethod.GET)
    public String queryAllBooks(){
        System.out.println("查询所有的图书");
        return "redirect:/index.jsp";
    }

    @RequestMapping(path = "/book", method = RequestMethod.POST)
    public String addBook(){
        System.out.println("添加图书");
        return "redirect:/index.jsp";
    }

    @RequestMapping(path = "/book/1", method = RequestMethod.PUT)
    public ModelAndView updateBook(){
        ModelAndView modelAndView = new ModelAndView();
        System.out .println("修改图书");
        modelAndView.setViewName("redirect:/index.jsp");
        return modelAndView;
//        System.out.println("修改图书");
//        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteBook(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("redirect:/index.jsp");
        System.out.println("删除图书");
        return modelAndView;
//        ModelAndView modelAndView = new ModelAndView();
//        System.out .println("删除图书");
//        modelAndView.setViewName("redirect:/index.jsp");
//        return modelAndView;
    }

}
