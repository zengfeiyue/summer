package com.summer.authorization.dao.sys;
import com.summer.api.base.BaseMapper;
import com.summer.api.entity.authorization.SysPermission;

import java.util.List;

/**
 * @author zengfeiyue
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission,Integer> {

    /**
     * 根据用户id获取权限列表
     * @param userId
     * @return
     */
    List<SysPermission>  getPermissionByUserId(Integer userId);

}