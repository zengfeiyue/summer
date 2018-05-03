package com.test.summer.admin.controller;

import com.test.summer.admin.entity.LoginEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author zengfeiyue  zfy on 2017/8/24.
 */
@RestController
public class TestController {

    @RequestMapping(value ="/test2")
    @ResponseBody
    public String test1(LoginEntity loginEntity){
        System.err.println("zzz");
       return "12345";
    }
    @Cacheable(value = "12311231")
    @RequestMapping("/test3")
    public String test2(){
        System.err.println("zzz");
        return null;
    }
}
