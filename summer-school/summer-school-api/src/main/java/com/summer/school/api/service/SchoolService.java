package com.summer.school.api.service;

import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.service.BaseService;
import com.summer.school.api.entity.School;

public interface SchoolService extends BaseService<School,Integer> {
    /**
     * 根据定位获取最近的一个学校
     * @param longitude
     * @param latitude
     * @return
     */
    ResponseBean queryLocation(String longitude, String latitude);
}
