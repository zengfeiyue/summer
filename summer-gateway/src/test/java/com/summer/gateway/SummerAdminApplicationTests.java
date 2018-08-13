package com.summer.gateway;

import com.summer.gateway.core.jwt.JwtTokenAuthentication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummerAdminApplicationTests {


	@Test
	public void contextLoads() {
		String token = JwtTokenAuthentication.getJwtToken("zzz",null);
		System.err.println(token);
	}

}
