package com.example.springbootproject.controller;

import com.example.springbootproject.domain.Demo;
import com.example.springbootproject.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//这种注解用于返回字符串
//@Controller这种则返回页面
//因为我们前后端要分离，所以只用@RestController
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

//    Controller -> Mapper -> XML
    @GetMapping("/list")
    public List<Demo> list(){
        return demoService.list();
    }
}
