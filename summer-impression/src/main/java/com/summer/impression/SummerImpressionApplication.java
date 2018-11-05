package com.summer.impression;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.summer")
public class SummerImpressionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummerImpressionApplication.class, args);
    }
}
