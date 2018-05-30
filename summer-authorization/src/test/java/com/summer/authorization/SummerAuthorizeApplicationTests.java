package com.summer.authorization;
import com.alibaba.dubbo.common.json.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.test.summer.authorization.dao.sys.SysGroupMapper;
import com.test.summer.authorization.dao.sys.SysMenuMapper;
import com.test.summer.authorization.entity.sys.SysGroup;
import com.test.summer.authorization.entity.sys.SysMenu;
import com.test.summer.authorization.service.ISysGroupService;
import com.test.summer.authorization.service.ISysMenuService;
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
	private ISysMenuService menuService;
	@Test
	public void contextLoads() {
		//PageInfo<SysMenu> pageInfo = menuService.findByPage(1,2);
		List list= sysMenuMapper.getMenuList();
		System.err.println(list.size());
	}

}
