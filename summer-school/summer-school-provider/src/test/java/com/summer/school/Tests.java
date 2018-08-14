package com.summer.school;

import com.summer.school.dao.MemberMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

    @Autowired
    private MemberMapper memberMapper;


    @Test
    public void contextLoads() {

    }

}
