package com.summer.gateway;

import com.summer.gateway.core.jwt.JwtTokenAuthentication;
import com.summer.gateway.dao.MemberMapper;
import com.summer.gateway.entity.Member;
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

	@Test
	public void contextLoads() {
		Member member =  memberService.selectByOpenId("ocu9V45-z_Wxfq9l2DI8QrkNIYAs");
		System.err.println(member);
	}

}
