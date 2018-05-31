package com.summer.gateway;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zengfeiyue
 */
@EnableDubboConfiguration
@SpringBootApplication
@EnableCaching
public class SummerGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerGateWayApplication.class, args);
	}
}
