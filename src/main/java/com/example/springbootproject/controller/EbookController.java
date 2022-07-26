package com.example.springbootproject.controller;

import com.example.springbootproject.req.EbookReq;
import com.example.springbootproject.resp.CommonResp;
import com.example.springbootproject.resp.EbookResp;
import com.example.springbootproject.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//这种注解用于返回字符串
//@Controller这种则返回页面
//因为我们前后端要分离，所以只用@RestController
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    //    Controller -> Mapper -> XML
    @GetMapping("/list")
    public CommonResp list(EbookReq req) {
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        List<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}
