package com.summer.school.dao;

import com.summer.common.base.dao.BaseMapper;
import com.summer.school.api.entity.ActivityVoteItem;

import java.util.List;

public interface ActivityVoteItemMapper  extends BaseMapper<ActivityVoteItem,Integer> {

    List<ActivityVoteItem> findByActivityId(Integer id);
}