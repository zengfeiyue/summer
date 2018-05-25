package com.test.summer.authorization.service;

import com.test.summer.api.base.service.IBaseService;
import com.test.summer.authorization.entity.sys.SysGroup;
import com.test.summer.authorization.entity.sys.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue
 */
public interface ISysMenuService extends IBaseService<SysMenu,Integer> {
    public List<Map> getPage();
}
