package com.atguigu.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author oono
 * @date 2020 11 10
 */

@Controller
public class upload {

    @RequestMapping(value = "/upload")
    //@RequestParam中的值要和表单中input标签的name属性相同
    public String upload(@RequestParam("username") String username, @RequestParam("photo") MultipartFile photo){
        try {
            System.out.println("用户名是：" + username);
            System.out.println("上传文件名是：" + photo.getOriginalFilename());
            photo.transferTo(new File("d:/" + photo.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpSession session) throws IOException {
        String fileName = "commons-io-1.4.jar";
        //获取servletContext对象
        ServletContext servletContext = session.getServletContext();
        //反射获取资源
        InputStream is = servletContext.getResourceAsStream("/files/" + fileName);
        byte[] buffer = IOUtils.toByteArray(is);
        is.close();
        //获取指定路径文件的数据类型
        String mimeType = servletContext.getMimeType("/files/" + fileName);
        MultiValueMap headers = new HttpHeaders();
        //设置返回的数据类型
        headers.add("Content-Type",mimeType);
        //设置响应头，告诉浏览器收到的数据统一以附件的形式用于下载
        headers.add("Content-Disposition","attachment; filename=" + fileName);
        //创建ResponseEntity返回客户端需要的数据
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(buffer,headers, HttpStatus.OK);
        return responseEntity;
    }


}
