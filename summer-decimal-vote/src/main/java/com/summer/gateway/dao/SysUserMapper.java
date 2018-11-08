package com.summer.gateway.dao;
import com.summer.gateway.core.base.dao.BaseMapper;
import com.summer.gateway.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author zengfeiyue
 */
public interface SysUserMapper extends BaseMapper<SysUser,Integer> {



    /**
     * 根据account查找用户
     * @param account
     * @return
     */
    SysUser getUserAccount(@Param("account") String account);

}