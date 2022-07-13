package com.lei.mycode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lei.mycode.mybatisplus.mapper")
public class MyCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCodeApplication.class, args);
    }

}
