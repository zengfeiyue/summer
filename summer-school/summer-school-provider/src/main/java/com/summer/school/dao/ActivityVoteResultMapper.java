package com.summer.school.dao;

import com.summer.common.base.BaseMapper;
import com.summer.school.api.entity.ActivityVoteResult;

import java.util.Map;

public interface ActivityVoteResultMapper extends BaseMapper<ActivityVoteResult,Integer> {

    ActivityVoteResult queryLastVoteRecord(Integer memberId);

    Map queryMemberVoteResult(Integer memberId);
}