package com.example.springbootproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//这种注解用于返回字符串
//@Controller这种则返回页面
//因为我们前后端要分离，所以只用@RestController
@RestController
public class TestController {
    //@GetMapping @RequestMapping(value = "/hello", method = RequestMethod.DELETE)等表示只接受指定请求
    //@RequestMapping则接受所有请求
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
