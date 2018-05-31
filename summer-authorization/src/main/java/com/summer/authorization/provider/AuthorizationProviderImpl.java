package com.summer.authorization.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.api.entity.authorization.SysUser;
import com.summer.api.service.authorization.AuthorizationProvider;
import com.summer.authorization.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 授权/鉴权 服务提供者
 * @author zengfeiyue
 */
@Service(version = "1.0",interfaceClass = AuthorizationProvider.class)
@org.springframework.stereotype.Service
public class AuthorizationProviderImpl implements AuthorizationProvider {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public SysUser getUserAccount(String account) {
        return sysUserService.getUserAccount(account);
    }
}
