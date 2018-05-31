package com.summer.authorization;

import com.summer.api.service.authorization.AuthorizationProvider;
import com.summer.authorization.dao.sys.SysMenuMapper;
import com.summer.authorization.service.SysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummerAuthorizeApplicationTests {

	@Autowired
	private AuthorizationProvider authorizationProvider;
	@Test
	public void contextLoads() {

		System.err.println(authorizationProvider.getUserAccount("zzz"));
	}

}
