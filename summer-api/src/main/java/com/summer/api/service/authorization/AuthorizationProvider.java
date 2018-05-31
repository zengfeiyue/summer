package com.summer.api.service.authorization;

import com.summer.api.entity.authorization.SysUser;

/**
 * 授权interface
 * @author zengfy
 */
public interface AuthorizationProvider {
    /**
     * 查找用户
     * @param account 用户名
     * @return
     */
    SysUser getUserAccount(String account);
}
