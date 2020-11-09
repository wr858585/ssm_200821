package com.atguigu.controller;

import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author oono
 * @date 2020 11 06
 */

@Controller
public class HelloController {

    /**
     * @RequestMapping注解用于给请求映射到方法
     * value属性配置方法对象的请求地址（唯一）
     * /斜杠表示在服务器上地址为：http://ip:port/工程路径
     * /hello表示地址为：http://ip:port/hello
     * @return
     */
    //params属性这里表示：username不能是abc（也可以不传username） && 不能传password
    @RequestMapping(value = "/hello", params = {"username!=abc","!password"})
    public String hello(){
        System.out.println("springmvc hello!");
        /**
         * /表示在服务器上地址为：http://ip:port/工程路径/，映射到代码的web目录
         * 返回值是跳转的路径，springmvc默认是请求转发（浏览器地址不会发生改变）
         */
        //配置了视图解析器InternalResourceViewResolver之后，就可以省略前缀和后缀了
        return "ok";
    }

    //headers属性表示：请求头中的属性attributes，而非请求的参数parameters
    @RequestMapping(value = "/headers", headers = "User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36")
    public String headers(){
        System.out.println("headers()");
        return "ok";
    }

    //methods属性表示，允许什么样的请求方式
    @RequestMapping(value = "/methods", method = RequestMethod.GET)
    public String method(){
        System.out.println("method() called!!");
        return "ok";
    }

    @RequestMapping(value = "/param1")
    public String param1(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession){
        System.out.println("request = " + request);
        System.out.println("请求的url地址：" + request.getRequestURI());
        System.out.println("请求的方式：" + request.getMethod());
        System.out.println("请求的工程路径：" + request.getContextPath());
        System.out.println("response = " + response);
        System.out.println("httpSession = " + httpSession);
        System.out.println("会话的编号：" + httpSession.getId());
        System.out.println("会话的超时时长：" + httpSession.getMaxInactiveInterval());
        return "ok";
    }

    @RequestMapping(path = "/param2")
    public String param2(String username, String password){
        //如果请求参数有，则获取成功；如果没有这些参数，获取的是null
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "ok";
    }

    @RequestMapping(path = "/param3")
    public String param3(String[] hobby){
        System.out.println("hobby = " + Arrays.asList(hobby));
        return "ok";
    }

    @RequestMapping(path = "/param4")
    public String param4(@RequestParam(name = "user", required = false, defaultValue = "我是默认值萌萌哒") String username){
        System.out.println("username = " + username);
        return "ok";
    }

    @RequestMapping(path = "/param5")
    public String param5(@RequestHeader(name = "user-Agent") String userAgent, @RequestHeader(name = "Accept-Encoding") String acceptEncoding){
        System.out.println("请求头userAgent = " + userAgent);
        System.out.println("请求头acceptEncoding = " + acceptEncoding);
        return "ok";
    }

    @RequestMapping(value = "/param6")
    public String param6(String jsessionId){
        System.out.println("cookie的值 = " + jsessionId);
        return "ok";
    }

    @RequestMapping(value = "/param7")
    public String param7(Person person){
        System.out.println("person = " + person);
        return "ok";
    }

    @RequestMapping(value = "/return1")
    public String return1(){
        System.out.println("return1()");
        return "ok";
    }

    //显式请求转发
    @RequestMapping(value = "/return2")
    public String return2(){
        System.out.println("return2()");
        return "forward:/pages/ok.jsp";
    }

    //显式请求重定向
    @RequestMapping(value = "/return3")
    public String return3(){
        System.out.println("return3()");
        return "redirect:/pages/ok.jsp";
    }

    @RequestMapping(value = "/modelAndView1")
    public ModelAndView modelAndView1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    @RequestMapping(path = "/modelAndView2")
    public ModelAndView modelAndView2(){
        ModelAndView modelAndView = new ModelAndView("ok");
        return modelAndView;
    }

    @RequestMapping(value = "modelAndView3")
    public ModelAndView modelAndView3(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/pages/ok.jsp");
        return modelAndView;
    }

    @RequestMapping(path = "/modelAndView4")
    public ModelAndView modelAndView4(){
        ModelAndView modelAndView = new ModelAndView("redirect:/pages/ok.jsp");
        return modelAndView;
    }





}