package com.summer.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zengfeiyue
 */
@SpringBootApplication
@EnableDubboConfiguration
public class SummerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerConsumerApplication.class, args);
	}
}
