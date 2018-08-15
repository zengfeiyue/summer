package com.summer.school.dao;
import com.summer.common.base.BaseMapper;
import com.summer.school.api.entity.Organization;
import org.apache.ibatis.annotations.Mapper;

/**
 * 组织表
 * @author zengfeiyue
 */
@Mapper
public interface OrganizationMapper extends BaseMapper<Organization,Integer> {

}