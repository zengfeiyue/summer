package com.summer.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.summer.api.service.TestService;
import com.test.summer.api.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference(version = "1.0.0",check = false)
    public TestService test;
    @RequestMapping(value = "/")
    public void hello(){
        System.err.println(test.getName("zfy","22"));
    }
}
