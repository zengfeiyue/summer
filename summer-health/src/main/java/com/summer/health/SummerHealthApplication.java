package com.summer.health;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zengfeiyue
 */
@SpringBootApplication
@EnableAdminServer
public class SummerHealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummerHealthApplication.class, args);
    }
}
