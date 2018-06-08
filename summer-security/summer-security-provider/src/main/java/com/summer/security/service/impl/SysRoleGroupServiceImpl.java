package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysRoleGroup;
import com.summer.security.service.SysRoleGroupService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysRoleGroupService.class)
@org.springframework.stereotype.Service
public class SysRoleGroupServiceImpl extends BaseServiceImpl<SysRoleGroup,Integer> implements SysRoleGroupService {

}
