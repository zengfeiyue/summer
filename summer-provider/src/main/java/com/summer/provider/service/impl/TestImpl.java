package com.summer.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.summer.api.service.TestService;

@Service(version = "1.0.0",interfaceClass = TestService.class)
@org.springframework.stereotype.Service
public class TestImpl implements TestService {
    @Override
    public String getName(String name,String age) {
        return name+age;
    }
}
