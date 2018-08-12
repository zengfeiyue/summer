package com.summer.school;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zengfy
 */
@EnableDubboConfiguration
@EnableTransactionManagement
@SpringBootApplication
@EnableCaching
@MapperScan("com.summer.school.dao")
public class SummerSchoolProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummerSchoolProviderApplication.class, args);
    }
}
