package com.summer.authorization.service.impl;

import com.summer.api.base.service.BaseServiceImpl;
import com.summer.authorization.dao.sys.SysMenuMapper;
import com.summer.api.entity.authorization.SysMenu;
import com.summer.api.entity.vo.MenuTree;
import com.summer.authorization.service.SysMenuService;
import com.summer.authorization.util.ConvertMenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<MenuTree> getUserAuthorizationMenu(Integer userId) {
        List<SysMenu> menuList = sysMenuMapper.getMenuList(userId);
        return ConvertMenuTree.convert(menuList);
    }
}
