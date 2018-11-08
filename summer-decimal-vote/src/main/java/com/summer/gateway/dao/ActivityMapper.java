package com.summer.gateway.dao;


import com.summer.gateway.core.base.dao.BaseMapper;
import com.summer.gateway.entity.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityMapper  extends BaseMapper<Activity,Integer> {

    List<Activity> findByPageJoin(Map search);
}