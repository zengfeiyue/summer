package com.summer.authorization.service;



import com.summer.api.base.service.BaseService;
import com.summer.api.entity.authorization.SysMenu;
import com.summer.api.entity.vo.MenuTree;

import java.util.List;
import java.util.Map;

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
