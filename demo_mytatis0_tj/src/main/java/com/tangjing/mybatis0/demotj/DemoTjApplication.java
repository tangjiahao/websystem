package com.tangjing.mybatis0.demotj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tangjing.mybatis0.demotj.base.mapper")
public class DemoTjApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTjApplication.class, args);
    }

}
