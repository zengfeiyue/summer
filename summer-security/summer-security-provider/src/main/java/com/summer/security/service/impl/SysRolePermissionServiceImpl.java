package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysRolePermission;
import com.summer.security.service.SysRolePermissionService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysRolePermissionService.class)
@org.springframework.stereotype.Service
public class SysRolePermissionServiceImpl extends BaseServiceImpl<SysRolePermission,Integer> implements SysRolePermissionService {

}
