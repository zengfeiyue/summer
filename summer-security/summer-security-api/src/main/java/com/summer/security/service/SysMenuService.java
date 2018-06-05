package com.summer.security.service;

import com.summer.common.base.service.BaseService;
import com.summer.security.entity.SysMenu;
import com.summer.security.vo.MenuTree;

import java.util.List;

/**
 * @author zengfeiyue
 */
public interface SysMenuService extends BaseService<SysMenu,Integer> {
    /**
     * 获取用户授权菜单
     * @param userId
     * @return
     */
    List<MenuTree> getUserAuthorizationMenu(Integer userId);
}
