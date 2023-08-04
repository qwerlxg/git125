package com;

import com.yc.Test1;
import com.yc.Test2_DataSourceConfig;
import com.yc.biz.AccountBizImplTest;
import com.yc.dao.AccountDaoJdbcTemplateImplTest;
import com.yc.dao.OpRecordDaoJdbcTemplateImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Suite  测试套件
@RunWith(Suite.class)
@Suite.SuiteClasses({Test1.class, Test2_DataSourceConfig.class, AccountDaoJdbcTemplateImplTest.class, OpRecordDaoJdbcTemplateImplTest.class, AccountBizImplTest.class})
public class TestSuit {
}
