package com.summer.authorization.service.impl;

import com.summer.api.base.service.BaseServiceImpl;
import com.summer.api.entity.authorization.SysUser;
import com.summer.authorization.dao.sys.SysUserMapper;
import com.summer.authorization.service.SysUserService;
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
