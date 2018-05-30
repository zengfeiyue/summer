package com.summer.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zengfeiyue
 */
@SpringBootApplication
@EnableDubboConfiguration
public class SummerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerProviderApplication.class, args);
	}
}
