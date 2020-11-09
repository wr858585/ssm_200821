package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author oono
 * @date 2020 11 07
 */

@Controller
public class ScopeController {

    @RequestMapping(value = "/requestScope")
    public String requestScope(HttpServletRequest request){
        System.out.println("requestScope()");
        request.setAttribute("reqKey1", "reqValue1");
        request.setAttribute("reqKey2", "reqValue2");
        return "scope_out";
    }

    @RequestMapping(path = "/sessionScope")
    public String sessionScope(HttpSession session){
        session.setAttribute("seKey1","seValue1");
        session.setAttribute("seKey2","seValue2");
        return "scope_out";
    }

    @RequestMapping(value = "/applicationScope")
    public String applicationScope(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("scKey1","scValue1");
        servletContext.setAttribute("scKey2","scValue2");
        return "scope_out";
    }






}
