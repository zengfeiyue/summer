package com.summer.security.dao;
import com.summer.common.base.dao.BaseMapper;
import com.summer.security.entity.SysUser;
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