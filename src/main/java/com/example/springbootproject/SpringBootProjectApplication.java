package com.example.springbootproject;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan("com.example.springbootproject.mapper")
public class SpringBootProjectApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootProjectApplication.class);

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringBootProjectApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("init success");
        LOG.info("address: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
