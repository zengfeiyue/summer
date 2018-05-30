package com.summer.authorization.service;



import com.summer.api.base.service.BaseService;
import com.summer.authorization.entity.sys.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue
 */
public interface SysMenuService extends BaseService<SysMenu,Integer> {
    public List<Map> getPage();
}
