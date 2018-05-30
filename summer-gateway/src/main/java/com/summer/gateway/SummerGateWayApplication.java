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
@MapperScan("com.summer.gateway.dao")
@EnableCaching
public class SummerGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerGateWayApplication.class, args);
	}
}
