package com.summer.authorization.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.api.service.authorization.IAuthorizationProvider;

/**
 * 授权/鉴权 服务提供者
 * @author zengfeiyue
 */
@Service(version = "1.0.0",interfaceClass = IAuthorizationProvider.class)
@org.springframework.stereotype.Service
public class AuthorizationImpl implements IAuthorizationProvider {

}
