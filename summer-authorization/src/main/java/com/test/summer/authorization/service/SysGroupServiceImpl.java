package com.test.summer.authorization.service;

import com.test.summer.api.base.service.BaseServiceImpl;
import com.test.summer.authorization.dao.sys.SysGroupMapper;
import com.test.summer.authorization.entity.sys.SysGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zengfeiyue
 */
@Service
public class SysGroupServiceImpl extends BaseServiceImpl<SysGroup,Integer> implements ISysGroupService{
    @Autowired
    private SysGroupMapper sysGroupMapper;
}
