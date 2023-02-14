package com.lucky.sgr.app.data.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lucky.sgr.app.data.center.*.mapper")
public class ApplicationDataCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDataCenterApplication.class, args);
    }

}
