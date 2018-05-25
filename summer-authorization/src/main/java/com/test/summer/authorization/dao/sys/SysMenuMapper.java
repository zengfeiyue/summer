package com.test.summer.authorization.dao.sys;
import com.test.summer.api.base.BaseMapper;
import com.test.summer.authorization.entity.sys.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue
 */
public interface SysMenuMapper extends BaseMapper<SysMenu,Integer> {

    public List<Map> getPage();

}