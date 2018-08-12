package com.summer.gateway.controller;

import com.summer.gateway.core.base.BaseController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author zengfeiyue  zfy on 2017/8/24.
 */
@RestController
public class TestController extends BaseController {

    @Autowired
    private RedisTemplate redisTemplate;

   /* @RequestMapping(value ="/test1")
    @ResponseBody
    public String test1(){
        System.err.println(Thread.currentThread().getId());
       *//* redisTemplate.opsForValue().set("1","1");*//*
        System.err.println("zzz"+request);
       return "12345";
    }
    @Cacheable(value = "12311231")
    @RequestMapping("/test3")
    public String test2(){
        System.err.println("zzz");
        return null;
    }*/

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value ="/test2" ,method = RequestMethod.GET)
    @ResponseBody
    public String test1(@ApiParam(name="id",value="用户id")  String id){
        System.err.println(id);
        redisTemplate.opsForValue().set("1","1");
        System.err.println("zzz"+request);
        return "12345";
    }


}
