package com.test.summer.admin.dao.sys;


import com.test.summer.admin.entity.sys.sysUserGroup;

public interface sysUserGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_group
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_group
     *
     * @mbggenerated
     */
    int insert(sysUserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_group
     *
     * @mbggenerated
     */
    int insertSelective(sysUserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_group
     *
     * @mbggenerated
     */
    sysUserGroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_group
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(sysUserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_group
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(sysUserGroup record);
}