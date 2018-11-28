package com.summer.security.dao;
import com.summer.common.base.dao.BaseMapper;
import com.summer.security.entity.SysPermission;

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