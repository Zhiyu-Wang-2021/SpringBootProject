package com.example.springbootproject.controller;

import com.example.springbootproject.domin.Test;
import com.example.springbootproject.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//这种注解用于返回字符串
//@Controller这种则返回页面
//因为我们前后端要分离，所以只用@RestController
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @Value("${test}")
    private String test;

    //@GetMapping @RequestMapping(value = "/hello", method = RequestMethod.DELETE)等表示只接受指定请求
    //@RequestMapping则接受所有请求
    @RequestMapping("/hello")
    public String hello(){
        return "hello world" + test;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello world name: " + name;
    }

//    Controller -> Mapper -> XML
    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
