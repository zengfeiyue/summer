package com.summer.school.dao;

import com.summer.common.base.BaseMapper;
import com.summer.school.api.entity.School;
import com.summer.school.api.model.SearchSchool;

import java.util.List;

public interface SchoolMapper extends BaseMapper<School,Integer> {
    /***
     * 根据定位/名称 匹配学校
     * @param searchSchool
     * @return
     */
    List<School> queryLocation(SearchSchool searchSchool);
}