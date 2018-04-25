package com.test.summer.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zengfeiyue
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.test.summer.admin.dao")
public class SummerAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerAdminApplication.class, args);
	}
}
