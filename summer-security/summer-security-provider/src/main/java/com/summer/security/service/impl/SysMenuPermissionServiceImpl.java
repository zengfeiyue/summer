package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysMenuPermission;
import com.summer.security.service.SysMenuPermissionService;


/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysMenuPermissionService.class)
@org.springframework.stereotype.Service
public class SysMenuPermissionServiceImpl extends BaseServiceImpl<SysMenuPermission,Integer> implements SysMenuPermissionService {

}
