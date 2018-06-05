package com.summer.security.service;

import com.summer.security.entity.SysUser;

/**
 * @author zengfeiyue
 */
public interface SysUserService {
    /**
     * 根据用户登录名称查找用户
     * @param account
     * @return
     */
    SysUser getUserAccount(String account);
}
