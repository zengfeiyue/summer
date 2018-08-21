package com.summer.gateway.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.auth.COSSigner;
import com.qcloud.cos.http.HttpMethodName;
import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.model.PageSearchModel;
import com.summer.gateway.core.jwt.JwtTokenAuthentication;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.entity.ActivityMemberForm;
import com.summer.school.api.entity.Advertisement;
import com.summer.school.api.entity.Organization;
import com.summer.school.api.model.CosSecurityToken;
import com.summer.school.api.model.SearchSchool;
import com.summer.school.api.service.ActivityService;
import com.summer.school.api.service.AdvertisementService;
import com.summer.school.api.service.OrganiztionService;
import com.summer.school.api.service.SchoolService;
import com.summer.security.entity.SysUser;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value ="/api/school")
public class SchoolController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${weixin.sessionKey_url}")
    private String sessionKey_url;
    @Value("${weixin.appId}")
    private String appid;
    @Value("${weixin.secret}")
    private String secret;

    @Value("${tencent.cos.secretId}")
    private String cosSecretId;

    @Value("${tencent.cos.secretKey}")
    private String cosSecretKey;

    @Reference(version = "0.1",timeout = 2000,mock = "return null",check = false)
    private SchoolService schoolService;

    @Reference(version = "0.1",timeout = 2000,mock = "return null",check = false)
    private ActivityService activityService;

    @Reference(version = "0.1",timeout = 2000,mock = "return null",check = false)
    private OrganiztionService organiztionService;

    @Reference(version = "0.1",timeout = 2000,mock = "return null",check = false)
    private AdvertisementService advertisementService;


    @ApiOperation(value="登录", notes="传递微信临时code，换取token")
    @RequestMapping(value ="/weixin_login" ,method = RequestMethod.POST,  produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String weixin_login(@ApiParam(name="code",value="微信登录code") @RequestBody JSONObject param){
        String code = "";
        if (param.containsKey("code")){
            code = param.getString("code");
        }
        String url ="https://api.weixin.qq.com/sns/jscode2session?appid=wxf784080a4b8c9eb3&secret=638cb23e9295c1cc0c322199b018c33f&grant_type=authorization_code&js_code="+code;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        /*{"session_key":"YDl\/WX01lgi9AG5tX6hhfA==","openid":"ocu9V4w2a3OQZq5ULNIWekTkPToo"}*/
        //token eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1MzQ1OTcyMDJ9.zaH2qtbldvTvqSHh9wSTtyBe8cbBBY7QaVTY1tg1XfHK_9BRxqDZ-ksbpcaZuL33YJCL-MA6b1kwh6X_QRKD7Q
        Map result = JSON.parseObject(responseEntity.getBody());
        if (result.containsKey("session_key")){
            String token = JwtTokenAuthentication.getJwtToken(result.get("openid").toString(),null);
            System.err.println(token);
            return JSON.toJSONString(new ResponseBean(200,"登录成功",token));
        }
       return JSON.toJSONString(new ResponseBean(500,"登录错误",null));
    }

    @ApiOperation(value="获取定位学校", notes="传递经纬度获取最近定位学校")
    @RequestMapping(value ="/location" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getLocation(@RequestBody SearchSchool search){
        ResponseBean responseBean = schoolService.queryLocation(search);
        return responseBean;
    }

    @ApiOperation(value="分页获取活动", notes="传递分页信息获取分页的活动")
    @RequestMapping(value ="/activity_page" ,method = RequestMethod.POST)
    @ResponseBody
    public PageInfo getActivityPage(@RequestBody PageSearchModel search){
        PageInfo<Activity> page = activityService.findByPage(search.getSearch(),search.getCurrentPage(),search.getPageSize());
        return page;
    }

    @ApiOperation(value="创建活动", notes="创建活动")
    @RequestMapping(value ="/activity_create" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityCreate(@RequestBody Activity activity){
        //todo 改造新增活动
        Integer count = activityService.insertSelective(activity);
        if (count>0)
            return new ResponseBean(200,"创建成功",null);
        else
            return new ResponseBean(500,"创建失败",null);
    }

    @ApiOperation(value="获取分页的组织列表")
    @RequestMapping(value ="/org_page" ,method = RequestMethod.POST)
    @ResponseBody
    public PageInfo activityPage(@RequestBody PageSearchModel search){
        PageInfo<Organization> page = organiztionService.findByPage(search.getSearch(),search.getCurrentPage(),search.getPageSize());
        return page;
    }

    @ApiOperation(value="获取首页横幅")
    @RequestMapping(value ="/advertisement_page" ,method = RequestMethod.POST)
    @ResponseBody
    public PageInfo advertisementPage(@RequestBody PageSearchModel search){
        PageInfo<Advertisement> page = advertisementService.findByPage(search.getSearch(),search.getCurrentPage(),search.getPageSize());
        return page;
    }

    @ApiOperation(value="给投票活动投票")
    @RequestMapping(value ="/activity_vote" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityVote(@RequestBody ActivityMemberForm voteform){
        ResponseBean responseBean = activityService.vote(voteform);
        return null;
    }

    @ApiOperation(value="生成cos的签名信息")
    @RequestMapping(value ="/cos_sign" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean cosSign(@RequestBody CosSecurityToken securityToken){
        // bucket 的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = "test-1251126190";
        COSCredentials cred = new BasicCOSCredentials(cosSecretId, cosSecretKey);
        COSSigner signer = new COSSigner();
        //设置过期时间为 1 个小时
        Date expiredTime = new Date(System.currentTimeMillis() + 3600L * 1000L);
        // 要签名的 key, 生成的签名只能用于对应此 key 的上传,文件名
        String key = securityToken.getPath();
        //PUT GET DELETE
        String sign ="";
        if (securityToken.getType().equalsIgnoreCase("PUT")){
            sign = signer.buildAuthorizationStr(HttpMethodName.PUT, key, cred, expiredTime);
        }
        if (securityToken.getType().equalsIgnoreCase("GET")){
            sign = signer.buildAuthorizationStr(HttpMethodName.GET, key, cred, expiredTime);
        }
        if (securityToken.getType().equalsIgnoreCase("DELETE")){
            sign = signer.buildAuthorizationStr(HttpMethodName.DELETE, key, cred, expiredTime);
        }
        Map data = new HashMap();
        data.put("sign",sign);
        data.put("secretId",cosSecretId);
        data.put("secretKey",cosSecretKey);

        ResponseBean responseBean = new ResponseBean(200,"请求签名成功",data);
        return responseBean;
    }

    /**
     * 获取登录用户
     * @return
     */
    @ModelAttribute
    public String getUserOpenId() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

}
