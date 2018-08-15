package com.summer.school.dao;

import com.summer.common.base.BaseMapper;
import com.summer.school.api.entity.School;
import com.summer.school.api.model.SearchSchool;

import java.util.List;

public interface SchoolMapper extends BaseMapper<School,Integer> {

    List<School> queryLocation(SearchSchool searchSchool);
}