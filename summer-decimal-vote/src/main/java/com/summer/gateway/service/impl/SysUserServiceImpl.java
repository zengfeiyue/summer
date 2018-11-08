package com.summer.gateway.service.impl;

import com.summer.gateway.core.base.service.BaseServiceImpl;
import com.summer.gateway.dao.SysUserMapper;
import com.summer.gateway.entity.SysUser;
import com.summer.gateway.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zengfeiyue
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,Integer> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserAccount(String account) {
        return sysUserMapper.getUserAccount(account);
    }
}
