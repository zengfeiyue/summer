package com.summer.school.dao;

import com.summer.common.base.BaseMapper;
import com.summer.school.api.entity.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityMapper  extends BaseMapper<Activity,Integer> {

    List<Activity> findByPageJoin(Map search);
}