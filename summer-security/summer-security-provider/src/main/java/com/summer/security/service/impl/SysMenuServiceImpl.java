package com.summer.security.service.impl;


import com.summer.common.base.service.BaseServiceImpl;
import com.summer.security.dao.SysMenuMapper;
import com.summer.security.entity.SysMenu;
import com.summer.security.service.SysMenuService;
import com.summer.security.util.ConvertMenuTree;
import com.summer.security.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zengfeiyue
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu,Integer> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<MenuTree> getUserAuthorizationMenu(Integer userId) {
        List<SysMenu> menuList = sysMenuMapper.getMenuList(userId);
        return ConvertMenuTree.convert(menuList);
    }
}
