package com.summer.gateway.core.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.summer.security.entity.SysUser;
import com.summer.security.service.SysUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 *
 * @author zengfeiyue
 * @date 17/2/7
 */
@Service
public class UrlUserService implements UserDetailsService {

    @Reference(version = "0.1",timeout = 2000,mock = "return null",check = false)
    protected SysUserService sysUserService;


    /**
     * 重写loadUserByUsername 方法获得 userdetails 类型用户
     * @param userName
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String userName) {
        SysUser sysUser = sysUserService.getUserAccount(userName);
        if (sysUser != null) {
            return sysUser;
        } else {
            throw new UsernameNotFoundException("gateway: " + userName + " do not exist!");
        }
    }
}