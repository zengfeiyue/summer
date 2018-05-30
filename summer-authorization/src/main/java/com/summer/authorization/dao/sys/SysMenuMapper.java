package com.summer.authorization.dao.sys;
import com.summer.authorization.entity.sys.SysMenu;
import com.test.summer.api.base.BaseMapper;
import com.test.summer.authorization.entity.sys.SysMenu;
import com.test.summer.authorization.entity.vo.MenuTree;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue
 */
public interface SysMenuMapper extends BaseMapper<SysMenu,Integer> {

    public List<Map> getPage();

    /**
     * 获取菜单列表
     * @return
     */
    List<SysMenu> getMenuList();
}