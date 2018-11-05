package com.summer.impression.core.security;


import com.summer.impression.entity.SysUser;
import com.summer.impression.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
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