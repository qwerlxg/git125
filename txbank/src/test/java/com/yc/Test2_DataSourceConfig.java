package com.yc;

import com.alibaba.druid.pool.DruidDataSource;
import com.yc.configs.Config;
import com.yc.configs.DataSourceConfig;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes ={Config.class, DataSourceConfig.class})
@Log4j2
public class Test2_DataSourceConfig {
    @Autowired
    private DataSourceConfig dsc;

    @Resource
    private Environment env;

    @Autowired
    @Qualifier("dataSource")
    private DataSource ds;

    @Autowired
    @Qualifier("dbcpDataSource")
    private DataSource dbcpDataSource;

    @Autowired
    @Qualifier("druidDataSource")
    private DataSource druidDataSource;

    @Autowired
    private TransactionManager tx;

    @Test
    public void testTransactionManager(){
        log.info(tx);
    }

    @Test
    public void testDruidDataSource() throws SQLException {
        Assert.assertNotNull(druidDataSource.getConnection());
        Connection connection = druidDataSource.getConnection();
        log.info(connection+"\t"+((DruidDataSource)dbcpDataSource).getInitialSize());
    }

    @Test
    public void testDBCPConnection() throws SQLException {
        Assert.assertNotNull(ds.getConnection());
        Connection connection = ds.getConnection();
        log.info(connection+"1234");
    }
    @Test
    public void testDbcpDataSource() throws SQLException {
        Assert.assertNotNull(dbcpDataSource.getConnection());
        Connection connection = dbcpDataSource.getConnection();
        log.info(connection);
    }



    @Test
    public void testPropertySource(){
        Assert.assertEquals("root",dsc.getUsername());
        log.info(dsc.getUsername());
    }

    @Test
    public void testEnvironment(){
        log.info(env.getProperty("jdbc.password")+"\t"+env.getProperty("user.home")+"qwer");
    }
}
