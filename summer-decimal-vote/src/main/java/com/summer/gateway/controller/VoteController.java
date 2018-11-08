package com.summer.gateway.controller;

import com.github.pagehelper.PageInfo;
import com.summer.gateway.core.base.common.ResponseBean;
import com.summer.gateway.core.base.model.PageSearchModel;
import com.summer.gateway.entity.Activity;
import com.summer.gateway.entity.ActivityVoteItem;
import com.summer.gateway.model.ActivityVoteModel;
import com.summer.gateway.model.QueryModel;
import com.summer.gateway.service.ActivityService;
import com.summer.gateway.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 投票
 * @author zengfeiyue
 */
@RestController
@RequestMapping(value ="/api/vote")
public class VoteController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private MemberService memberService;

    @ApiOperation(value="创建投票活动")
    @RequestMapping(value ="/activity_create" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityCreate(@RequestBody ActivityVoteModel activityVoteModel, @RequestHeader(value="memberId") Integer memberId){
        ResponseBean responseBean = activityService.create(activityVoteModel,memberId);
        return responseBean;
    }

    @ApiOperation(value="参加投票活动")
    @RequestMapping(value ="/activity_join" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityJoin(@RequestBody ActivityVoteItem item){
        ResponseBean responseBean = activityService.createJoin(item);
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
