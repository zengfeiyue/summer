package com.test.summer.authorization;
import com.test.summer.authorization.dao.sys.SysGroupMapper;
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
	@Test
	public void contextLoads() {
		System.err.println(sysGroupMapper.deleteByPrimaryKey(1));
	}

}
