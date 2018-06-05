package com.summer.security;

import com.summer.security.dao.SysPermissionMapper;
import com.summer.security.entity.SysPermission;
import com.summer.security.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummerSecurityProviderApplicationTests {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Test
    public void contextLoads() {
        List<SysPermission>  sysPermissions = sysPermissionMapper.getPermissionByUserId(1);
        System.err.println(sysPermissions);
    }

}
