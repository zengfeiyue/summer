package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysUserRole;
import com.summer.security.service.SysUserRoleService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysUserRoleService.class)
@org.springframework.stereotype.Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole,Integer> implements SysUserRoleService {

}
