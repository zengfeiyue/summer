package com.summer.school.dao;

import com.summer.common.base.BaseMapper;
import com.summer.school.api.entity.ActivityVoteResult;

public interface ActivityVoteResultMapper extends BaseMapper<ActivityVoteResult,Integer> {

    ActivityVoteResult queryLastVoteRecord(String openId);
}