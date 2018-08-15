package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.School;
import com.summer.school.api.model.SearchSchool;
import com.summer.school.api.service.SchoolService;
import com.summer.school.dao.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = SchoolService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class SchoolServiceImpl extends BaseServiceImpl<School, Integer> implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public ResponseBean queryLocation(SearchSchool searchSchool) {
        /*School school = schoolMapper.selectByPrimaryKey(1);*/
        List<School> school = schoolMapper.queryLocation(searchSchool);
        return new ResponseBean(200,"",school);
    }
}
