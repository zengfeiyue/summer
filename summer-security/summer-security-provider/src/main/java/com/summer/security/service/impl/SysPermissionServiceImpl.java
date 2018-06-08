package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysPermission;
import com.summer.security.service.SysPermissionService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysPermissionService.class)
@org.springframework.stereotype.Service
public class SysPermissionServiceImpl  extends BaseServiceImpl<SysPermission,Integer> implements SysPermissionService {

}
