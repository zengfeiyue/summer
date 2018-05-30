package com.summer.authorization;

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
	public SysMenuMapper sysMenuMapper;

	@Autowired
	private SysMenuService menuService;
	@Test
	public void contextLoads() {
		//PageInfo<SysMenu> pageInfo = menuService.findByPage(1,2);
		List list= sysMenuMapper.getMenuList();
		System.err.println(list.size());
	}

}
