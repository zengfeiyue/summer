package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysRole;
import com.summer.security.service.SysRoleService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysRoleService.class)
@org.springframework.stereotype.Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole,Integer> implements SysRoleService {

}
