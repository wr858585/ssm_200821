package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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

    @RequestMapping(value = "/applicationScope")//也可以叫/servletContextScope
    public String applicationScope(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("scKey1","scValue1");
        servletContext.setAttribute("scKey2","scValue2");
        return "scope_out";
    }

    @RequestMapping(value = "/mapToRequest")
    public String mapToRequest(Map<String,Object> map){
        System.out.println("mapToRequest");
         //保存到map中的数据，会自动保存到Request域中
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        return "scope_out";
    }

    @RequestMapping(value = "/modelToRequest")
    public String modelToRequest(Model model){
        System.out.println("modelToRequest");
        //保存到model中的数据，也会自动保存到Request域中
        model.addAttribute("modelKey1","modelValue1");
        model.addAttribute("modelKey2","modelValue2");
        model.addAttribute("modelKey3","modelValue3");
        return "scope_out";
    }

    @RequestMapping(value = "/modelMapToRequest")
    public String modelMapToRequest(ModelMap modelMap){
        System.out.println("modelMapToRequest");
        modelMap.addAttribute("modelMapKey1","modelMapValue1");
        modelMap.addAttribute("modelMapKey2","modelMapValue2");
        modelMap.addAttribute("modelMapKey3","modelMapValue3");
        return "scope_out";
    }





}
