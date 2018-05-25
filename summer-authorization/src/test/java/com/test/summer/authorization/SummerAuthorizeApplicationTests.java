package com.test.summer.authorization;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.test.summer.authorization.dao.sys.SysGroupMapper;
import com.test.summer.authorization.entity.sys.SysGroup;
import com.test.summer.authorization.entity.sys.SysMenu;
import com.test.summer.authorization.service.ISysGroupService;
import com.test.summer.authorization.service.ISysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummerAuthorizeApplicationTests {
	@Autowired
	public SysGroupMapper sysGroupMapper;

	@Autowired
	private ISysMenuService menuService;
	@Test
	public void contextLoads() {
		//PageInfo<SysMenu> pageInfo = menuService.findByPage(1,2);
		System.err.println(menuService.getPage());
	}

}
