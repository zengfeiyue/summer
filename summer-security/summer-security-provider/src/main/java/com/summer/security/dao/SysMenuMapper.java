package com.summer.security.dao;
import com.summer.common.base.BaseMapper;
import com.summer.security.entity.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue
 */
public interface SysMenuMapper extends BaseMapper<SysMenu,Integer> {

    List<Map> getPage();

    /**
     * 获取菜单列表
     * @return
     */
    List<SysMenu> getMenuList(Integer userId);
}