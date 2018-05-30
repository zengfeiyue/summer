package com.summer.authorization;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zengfeiyue
 */
@EnableDubboConfiguration
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.test.summer.authorization.dao")
public class SummerAuthorizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerAuthorizeApplication.class, args);
	}
}
