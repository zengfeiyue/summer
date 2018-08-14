package com.summer.gateway.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.summer.common.base.common.ResponseBean;
import com.summer.gateway.core.jwt.JwtTokenAuthentication;
import com.summer.school.api.model.SearchSchool;
import com.summer.school.api.service.SchoolService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
@RequestMapping(value ="/api/school" ,  produces="text/plain;charset=UTF-8")
public class SchoolController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${weixin.sessionKey_url}")
    private String sessionKey_url;
    @Value("${weixin.appId}")
    private String appid;
    @Value("${weixin.secret}")
    private String secret;

    @Reference(version = "0.1",timeout = 2000,mock = "return null",check = false)
    protected SchoolService schoolService;

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
    @RequestMapping(value ="/location" ,method = RequestMethod.POST,  produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String getLocation(@RequestBody SearchSchool search){
        ResponseBean responseBean = schoolService.queryLocation(search);
        return JSON.toJSONString(responseBean);
    }

}
