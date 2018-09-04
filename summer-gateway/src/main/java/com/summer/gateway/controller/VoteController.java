package com.summer.gateway.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.model.PageSearchModel;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.model.ActivityVoteModel;
import com.summer.school.api.service.ActivityService;
import com.summer.school.api.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 投票
 * @author zengfeiyue
 */
@RestController
@RequestMapping(value ="/api/vote")
public class VoteController {
    @Reference(version = "0.1",timeout = 2000,mock = "return null",check = false)
    private ActivityService activityService;

    @Reference(version = "0.1",timeout = 2000,mock = "return null",check = false)
    private MemberService memberService;

    @ApiOperation(value="创建投票活动")
    @RequestMapping(value ="/activity_create" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityCreate(@RequestBody ActivityVoteModel activityVoteModel){
        ResponseBean responseBean = activityService.create(activityVoteModel);
        return responseBean;
    }

    @ApiOperation(value="分页获取我创建的活动", notes="传递分页信息获取分页的活动")
    @RequestMapping(value ="/activity_page" ,method = RequestMethod.POST)
    @ResponseBody
    public PageInfo getActivityPage(@RequestBody PageSearchModel search){
        PageInfo<Activity> page = activityService.findByPage(search.getSearch(),search.getCurrentPage(),search.getPageSize());
        return page;
    }
}
