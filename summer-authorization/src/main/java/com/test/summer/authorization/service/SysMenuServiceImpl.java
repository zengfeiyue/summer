package com.test.summer.authorization.service;

import com.test.summer.api.base.service.BaseServiceImpl;
import com.test.summer.authorization.dao.sys.SysMenuMapper;
import com.test.summer.authorization.entity.sys.SysGroup;
import com.test.summer.authorization.entity.sys.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu,Integer> implements ISysMenuService{

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<Map> getPage(){
       return sysMenuMapper.getPage();
    }
}
