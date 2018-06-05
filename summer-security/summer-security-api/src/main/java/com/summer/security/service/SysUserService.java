package com.summer.security.service;

import com.summer.common.base.service.BaseService;
import com.summer.security.entity.SysUser;

/**
 * @author zengfeiyue
 */
public interface SysUserService extends BaseService<SysUser,Integer> {
    /**
     * 根据用户登录名称查找用户
     * @param account
     * @return
     */
    SysUser getUserAccount(String account);
}
