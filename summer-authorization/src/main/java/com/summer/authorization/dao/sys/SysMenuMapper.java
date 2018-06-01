package com.summer.authorization.dao.sys;
import com.summer.api.base.BaseMapper;
import com.summer.api.entity.authorization.SysMenu;

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