package com.summer.gateway.dao;

import com.summer.gateway.core.base.dao.BaseMapper;
import com.summer.gateway.entity.ActivityVoteResult;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ActivityVoteResultMapper extends BaseMapper<ActivityVoteResult,Integer> {

    ActivityVoteResult queryLastVoteRecord(Integer memberId);

    Map queryMemberVoteResult(@Param("activity") Integer activity, @Param("memberId") Integer memberId);
}