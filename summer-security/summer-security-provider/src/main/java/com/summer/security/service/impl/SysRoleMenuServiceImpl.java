package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysRoleMenu;
import com.summer.security.service.SysRoleMenuService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysRoleMenuService.class)
@org.springframework.stereotype.Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenu,Integer> implements SysRoleMenuService {

}
