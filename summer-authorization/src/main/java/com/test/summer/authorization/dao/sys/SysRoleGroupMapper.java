package com.test.summer.authorization.dao.sys;
import com.test.summer.authorization.entity.sys.SysRoleGroup;

/**
 * @author zengfeiyue
 */
public interface SysRoleGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_group
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_group
     *
     * @mbggenerated
     */
    int insert(SysRoleGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_group
     *
     * @mbggenerated
     */
    int insertSelective(SysRoleGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_group
     *
     * @mbggenerated
     */
    SysRoleGroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_group
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRoleGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_group
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRoleGroup record);
}