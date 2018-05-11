package com.test.summer.authorization.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.summer.api.service.authorization.IAuthorization;

/**
 * 授权/鉴权 服务提供者
 * @author zengfeiyue
 */
@Service(version = "1.0.0",interfaceClass = IAuthorization.class)
@org.springframework.stereotype.Service
public class AuthorizationImpl implements IAuthorization {

}
