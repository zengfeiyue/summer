package com.summer.gateway.core.security;

import com.summer.gateway.entity.sys.SysPermission;
import com.summer.gateway.entity.sys.SysUser;
import com.test.summer.gateway.dao.sys.SysPermissionMapper;
import com.test.summer.gateway.dao.sys.SysUserMapper;
import com.test.summer.gateway.entity.sys.SysPermission;
import com.test.summer.gateway.entity.sys.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zengfeiyue
 * @date 17/2/7
 */
@Service
public class UrlUserService implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysPermissionMapper permissionMapper;

    /**
     * 重写loadUserByUsername 方法获得 userdetails 类型用户
     * @param userName
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String userName) {
        SysUser sysUser = userMapper.getByUserName(userName);
        if (sysUser != null) {
            List<SysPermission> sysPermissions = permissionMapper.getByUserId(sysUser.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            for (SysPermission sysPermission : sysPermissions) {
                if (sysPermission != null && sysPermission.getName()!=null) {
                    GrantedAuthority grantedAuthority = new UrlGrantedAuthority(sysPermission.getUrl(), sysPermission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            sysUser.setGrantedAuthorities(grantedAuthorities);

            return sysUser;
        } else {
            throw new UsernameNotFoundException("gateway: " + userName + " do not exist!");
        }
    }
}