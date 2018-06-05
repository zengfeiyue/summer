package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.dao.SysUserMapper;
import com.summer.security.entity.SysUser;
import com.summer.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysUserService.class)
@org.springframework.stereotype.Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,Integer> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserAccount(String account) {
        return sysUserMapper.getUserAccount(account);
    }
}
