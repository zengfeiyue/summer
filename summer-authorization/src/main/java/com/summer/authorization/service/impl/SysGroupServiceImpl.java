package com.summer.authorization.service.impl;

import com.summer.api.base.service.BaseServiceImpl;
import com.summer.authorization.dao.sys.SysGroupMapper;
import com.summer.authorization.entity.sys.SysGroup;
import com.summer.authorization.service.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zengfeiyue
 */
@Service
public class SysGroupServiceImpl extends BaseServiceImpl<SysGroup,Integer> implements SysGroupService {
    @Autowired
    private SysGroupMapper sysGroupMapper;
}
