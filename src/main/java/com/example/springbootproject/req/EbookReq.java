package com.example.springbootproject.req;

public class EbookReq {
    //url里面的参数可以自动映射到这里的同名变量
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}