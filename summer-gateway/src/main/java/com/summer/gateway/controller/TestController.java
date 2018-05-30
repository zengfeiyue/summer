package com.summer.gateway.controller;

import com.summer.gateway.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author zengfeiyue  zfy on 2017/8/24.
 */
@RestController
public class TestController extends BaseController{

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value ="/test1")
    @ResponseBody
    public String test1(LoginEntity loginEntity){
        System.err.println(Thread.currentThread().getId());
        redisTemplate.opsForValue().set("1","1");
        System.err.println("zzz"+request);
       return "12345";
    }
    @Cacheable(value = "12311231")
    @RequestMapping("/test3")
    public String test2(){
        System.err.println("zzz");
        return null;
    }


}
