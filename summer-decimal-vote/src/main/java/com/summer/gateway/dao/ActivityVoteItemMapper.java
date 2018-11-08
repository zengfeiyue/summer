package com.summer.gateway.dao;



import com.summer.gateway.core.base.dao.BaseMapper;
import com.summer.gateway.entity.ActivityVoteItem;

import java.util.List;

public interface ActivityVoteItemMapper  extends BaseMapper<ActivityVoteItem,Integer> {

    List<ActivityVoteItem> findByActivityId(Integer id);
}