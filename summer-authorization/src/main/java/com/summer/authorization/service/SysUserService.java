package com.summer.authorization.service;

import com.summer.api.base.service.BaseService;
import com.summer.api.entity.authorization.SysUser;

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
