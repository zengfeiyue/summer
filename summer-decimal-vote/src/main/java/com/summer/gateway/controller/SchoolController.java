package com.summer.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.auth.COSSigner;
import com.qcloud.cos.http.HttpMethodName;
import com.summer.gateway.StorageSts;
import com.summer.gateway.core.base.common.ResponseBean;
import com.summer.gateway.core.jwt.JwtTokenAuthentication;
import com.summer.gateway.entity.Activity;
import com.summer.gateway.entity.Member;
import com.summer.gateway.model.CosSecurityToken;
import com.summer.gateway.service.ActivityService;
import com.summer.gateway.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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


    @Autowired
    private ActivityService activityService;

    @Autowired
    private MemberService memberService;


    @ApiOperation(value="登录", notes="传递微信临时code，换取token")
    @RequestMapping(value ="/weixin_login" ,method = RequestMethod.POST)
    @ResponseBody
    public String weixin_login(@ApiParam(name="code",value="微信登录code") @RequestBody JSONObject param){
        String code = "";
        if (param.containsKey("code")){
            code = param.getString("code");
        }
        String url ="https://api.weixin.qq.com/sns/jscode2session?appid=wx6e2ff7ab07d81ebe&secret=eee894b9e637278b85403443d45b3ddc&grant_type=authorization_code&js_code="+code;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        Map result = JSON.parseObject(responseEntity.getBody());
        if (result.containsKey("session_key")){
            String token = JwtTokenAuthentication.getJwtToken(result.get("openid").toString(),null);

            Member member = memberService.selectByOpenId(result.get("openid").toString());
            if (member==null){
                member = new Member();
                member.setOpenId(result.get("openid").toString());
                member.setToken("");
                member.setSessionKey(((JSONObject) result).getString("session_key"));
                memberService.insertSelective(member);
            }
            Map map = new HashMap();
            map.put("token",token);
            map.put("memberId",member.getId());
            return JSON.toJSONString(new ResponseBean(200,"登录成功",map));
        }
       return JSON.toJSONString(new ResponseBean(500,"登录错误",null));
    }

    @ApiOperation(value="获取活动详情", notes="获取活动详情")
    @RequestMapping(value ="/activity_detail" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean activityDetail(@RequestBody Activity activity){
        Activity select = activityService.selectByPrimaryKey(activity.getId());
        return new ResponseBean(200,"获取活动详情成功",select);

    }

    @ApiOperation(value="生成cos的签名信息")
    @RequestMapping(value ="/cos_sign" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean cosSign(@RequestBody CosSecurityToken securityToken){
        // bucket 的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = "test-1251126190";
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        // 您的 SecretID
        config.put("SecretId", cosSecretId);
        // 您的 SecretKey
        config.put("SecretKey", cosSecretKey);
        // 临时密钥有效时长，单位是秒，如果没有设置，默认是30分钟
        config.put("durationInSeconds", 1800);
        com.qcloud.Utilities.Json.JSONObject credential = StorageSts.getCredential(config);
        if (!credential.getString("codeDesc").equalsIgnoreCase("Success")){
            ResponseBean responseBean = new ResponseBean(500,"获取签名失败",null);
            return responseBean;
        }
        COSCredentials cred = new BasicCOSCredentials(credential.getJSONObject("data").getJSONObject("credentials").getString("tmpSecretId"), credential.getJSONObject("data").getJSONObject("credentials").getString("tmpSecretKey"));
        COSSigner signer = new COSSigner();
        //设置过期时间为 1 个小时
        Date expiredTime = new Date(System.currentTimeMillis() + 1800);
        // 要签名的 key, 生成的签名只能用于对应此 key 的上传,文件名
        String key = securityToken.getPath();
        //PUT GET DELETE
        String sign ="";
        if (securityToken.getMethod().equalsIgnoreCase("POST")){
            sign = signer.buildAuthorizationStr(HttpMethodName.POST, key, cred, expiredTime);
        }
        if (securityToken.getMethod().equalsIgnoreCase("PUT")){
            sign = signer.buildAuthorizationStr(HttpMethodName.PUT, key, cred, expiredTime);
        }
        if (securityToken.getMethod().equalsIgnoreCase("GET")){
            sign = signer.buildAuthorizationStr(HttpMethodName.GET, key, cred, expiredTime);
        }
        if (securityToken.getMethod().equalsIgnoreCase("DELETE")){
            sign = signer.buildAuthorizationStr(HttpMethodName.DELETE, key, cred, expiredTime);
        }
        Map data = new HashMap();
        data.put("sign",sign);
        data.put("sessionToken",credential.getJSONObject("data").getJSONObject("credentials").getString("sessionToken"));
        ResponseBean responseBean = new ResponseBean(200,"请求签名成功",data);
        return responseBean;
    }

    /**
     * 获取登录用户OpenId
     * @return
     */
    @ModelAttribute
    public String getUserOpenId() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
