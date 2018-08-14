package com.summer.school.api.service;

import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.service.BaseService;
import com.summer.school.api.entity.School;
import com.summer.school.api.model.SearchSchool;

public interface SchoolService extends BaseService<School,Integer> {
    /**
     * 根据定位获取最近的一个学校
     * @param searchSchool
     * @return
     */
    ResponseBean queryLocation(SearchSchool searchSchool);
}
