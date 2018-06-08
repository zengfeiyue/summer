package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysUserGroup;
import com.summer.security.service.SysUserGroupService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysUserGroupService.class)
@org.springframework.stereotype.Service
public class SysUserGroupServiceImpl extends BaseServiceImpl<SysUserGroup,Integer>implements SysUserGroupService {

}
