package com.yc.dao;


import com.yc.bean.Account;
import com.yc.configs.Config;
import com.yc.configs.DataSourceConfig;
import com.yc.dao.AccountDao;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, DataSourceConfig.class})
@Log4j2
public class AccountDaoJdbcTemplateImplTest extends TestCase {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void updata(){
        accountDao.update(1,10);
    }

    @Test
    public void findCount(){
        int total = accountDao.findCount();
        Assert.assertEquals(2,total);
    }

    @Test
    public void findAll(){
        List<Account> list = this.accountDao.findAll();
        log.info(list);
    }

    @Test
    public void findById(){
        Account account = this.accountDao.findById(2);
        log.info(account);
    }

    @Test
    public void insert(){
        int accountid = accountDao.insert(100);
        log.info("新开账户："+accountid);
        Assert.assertNotNull(accountid);
    }
    @Test
    public void delete(){
        accountDao.delete(3);
    }
}
