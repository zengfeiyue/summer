package com.summer.authorization.dao.sys;
import com.summer.api.base.BaseMapper;
import com.summer.api.entity.authorization.SysUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author zengfeiyue
 */
public interface SysUserMapper extends BaseMapper<SysUser,Integer> {



    /**
     * 根据account查找用户
     * @param account
     * @return
     */
    SysUser getUserAccount(String account);

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "cnname", column = "cnname")
    })
    SysUser test();
}