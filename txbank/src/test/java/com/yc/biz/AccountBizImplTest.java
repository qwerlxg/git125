package com.yc.biz;

import com.yc.bean.Account;
import com.yc.configs.Config;
import com.yc.configs.DataSourceConfig;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, DataSourceConfig.class})
@Log4j2
public class AccountBizImplTest extends TestCase {

    @Autowired
    private AccountBiz accountBiz;

    @Test
    public void openAccount() {
        Account account = accountBiz.findAccount(1);
        Assert.assertNotNull(account);
    }

    @Test
    public void deposit() {
        Account account = accountBiz.deposit(1, 10);
        Assert.assertNotNull(account);
    }

    @Test
    public void testDeposit() {
    }

    @Test
    public void withdraw() {
        Account account = accountBiz.withdraw(1, 10);
        Assert.assertNotNull(account);
    }

    @Test
    public void testWithdraw() {
    }

    @Test
    public void transfer() {
        // UncategorizedSQLException
        Account account = accountBiz.transfer(1, 90, 2);
        Assert.assertNotNull(account);
    }

    @Test
    public void findAccount() {
        Account account = accountBiz.findAccount(1);
        Assert.assertNotNull(account);
    }
}