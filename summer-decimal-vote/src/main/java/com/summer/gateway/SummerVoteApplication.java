package com.summer.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zengfeiyue
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableCaching
@MapperScan("com.summer.gateway.dao")
public class SummerVoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerVoteApplication.class, args);
	}
}
