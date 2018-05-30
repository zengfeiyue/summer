package com.summer.authorization.service.impl;

import com.summer.api.base.service.BaseServiceImpl;
import com.summer.authorization.dao.sys.SysMenuMapper;
import com.summer.authorization.entity.sys.SysMenu;
import com.summer.authorization.entity.vo.MenuTree;
import com.summer.authorization.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu,Integer> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<Map> getPage(){
       return sysMenuMapper.getPage();
    }

    public List<MenuTree> getMenuList(){
        List<SysMenu> list= sysMenuMapper.getMenuList();

        return null;
    }
}
