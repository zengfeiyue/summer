package com.summer.gateway;

import com.github.pagehelper.PageInfo;
import com.summer.gateway.core.jwt.JwtTokenAuthentication;
import com.summer.gateway.dao.MemberMapper;
import com.summer.gateway.entity.Activity;
import com.summer.gateway.entity.Member;
import com.summer.gateway.service.ActivityService;
import com.summer.gateway.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummerAdminApplicationTests {
	@Autowired
	private MemberService memberService;

	@Autowired
	private ActivityService activityService;
	@Test
	public void contextLoads() {
		PageInfo<Activity> page = activityService.findByPage(null,1,10);
		System.err.println(page);
	}

}
