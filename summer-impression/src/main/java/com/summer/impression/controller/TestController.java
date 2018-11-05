package com.summer.impression.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zengfeiyue  zfy on 2017/8/24.
 */
@RestController
public class TestController{

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value ="/test1")
    @ResponseBody
    public String test1(){
        System.err.println(Thread.currentThread().getId());
        //redisTemplate.opsForValue().set("1","1");
        //System.err.println("zzz"+request);
       return "12345";
    }
    @Cacheable(value = "12311231")
    @RequestMapping("/test3")
    public String test2(){
        System.err.println("zzz");
        return null;
    }




}
