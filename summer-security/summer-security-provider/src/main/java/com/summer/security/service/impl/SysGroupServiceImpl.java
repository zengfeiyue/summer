package com.summer.security.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.entity.SysGroup;
import com.summer.security.service.SysGroupService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SysGroupService.class)
@org.springframework.stereotype.Service
public class SysGroupServiceImpl extends BaseServiceImpl<SysGroup,Integer> implements SysGroupService {

}
