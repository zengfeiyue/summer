package com.summer.gateway.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.model.PageSearchModel;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.entity.ActivityVoteItem;
import com.summer.school.api.model.ActivityVoteModel;
import com.summer.school.api.model.QueryModel;
import com.summer.school.api.service.ActivityService;
import com.summer.school.api.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @ApiOperation(value="我参与的", notes="我参与的")
    @RequestMapping(value ="/activity_page_join" ,method = RequestMethod.POST)
    @ResponseBody
    public PageInfo getActivityPageJoin(@RequestBody PageSearchModel search,@RequestHeader(value="memberId") Integer memberId){
        search.getSearch().put("memberId",memberId);
        PageInfo<Activity> page = activityService.findByPageJoin(search.getSearch(),search.getCurrentPage(),search.getPageSize());
        return page;
    }

    @ApiOperation(value="获取活动详情", notes="获取活动详情")
    @RequestMapping(value ="/activity_detail" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityDetail(@RequestBody QueryModel queryModel){
        ActivityVoteModel activityVoteModel = activityService.queryVoteDetail(queryModel.getId());
        return new ResponseBean(200,"获取活动详情成功",activityVoteModel);

    }

    @ApiOperation(value="给投票项目投票", notes="给投票项目投票")
    @RequestMapping(value ="/activity_vote" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityVote(@RequestBody QueryModel queryModel,@RequestHeader(value="memberId") Integer memberId){

        ResponseBean responseBean = activityService.activityVote(queryModel.getId(),memberId);
        return responseBean;

    }

    @ApiOperation(value="投票活动开始", notes="投票活动开始")
    @RequestMapping(value ="/activity_start" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityStart(@RequestBody QueryModel queryModel){
        ResponseBean responseBean = activityService.start(queryModel);
        return responseBean;

    }

    @ApiOperation(value="投票活动结束", notes="投票活动结束")
    @RequestMapping(value ="/activity_stop" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityStop(@RequestBody QueryModel queryModel){
        ResponseBean responseBean = activityService.stop(queryModel);
        return responseBean;

    }

}
