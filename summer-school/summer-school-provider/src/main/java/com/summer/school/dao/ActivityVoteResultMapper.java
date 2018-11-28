package com.summer.school.dao;

import com.summer.common.base.dao.BaseMapper;
import com.summer.school.api.entity.ActivityVoteResult;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ActivityVoteResultMapper extends BaseMapper<ActivityVoteResult,Integer> {

    ActivityVoteResult queryLastVoteRecord(Integer memberId);

    Map queryMemberVoteResult(@Param("activity") Integer activity,@Param("memberId") Integer memberId);
}