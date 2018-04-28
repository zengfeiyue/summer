package com.test.summer.admin.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zengfeiyue  zfy on 2017/8/24.
 */
@RestController
public class TestController {

    @Cacheable(value = "12311231")
    @RequestMapping("/test2")
    public String test1(){
        System.err.println("zzz");
       return null;
    }
    @Cacheable(value = "12311231")
    @RequestMapping("/test3")
    public String test2(){
        System.err.println("zzz");
        return null;
    }
}
