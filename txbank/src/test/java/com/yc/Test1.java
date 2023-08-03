package com.yc;

import com.yc.biz.AccountBiz;
import com.yc.configs.Config;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Test1 extends TestCase {
    //DI注入
    @Resource
    private AccountBiz accountBiz;

    @Test
    public void testAddccount(){
        accountBiz.addAcount(1,99);
    }

    @Test
    public  void testAdd(){
        int x = 4, y = 4;
        Assert.assertEquals(8,x+y);
    }
}
