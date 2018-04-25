package com.test.summer.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zengfeiyue  zfy on 2017/8/24.
 */
@RestController
public class TestController {


    @RequestMapping("/test2")
    public String test1(){
        System.err.println("zzz");
       return null;
    }

}
