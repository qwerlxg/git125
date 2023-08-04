package com.yc.configs;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@Data
@Log4j2
public class DataSourceConfig {
    //利用DI将db.properties中的东西注入
    @Value("root")
    private String username;
    @Value("123456")
    private String password;
    @Value("jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=UTF-8")
    private String url;
    @Value("com.mysql.cj.jdbc.Driver")
    private String driverclass;
    @Value("#{T(Runtime).getRuntime().availableProcessors()*2}")
    private int cpuCount;
    //以上的东西冲db.properties中读后存到spring容器的Environment的变量

    @Bean
    public DriverManagerDataSource jdbcDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    public TransactionManager dataSourceTransactionManager(@Autowired @Qualifier(value = "druidDataSource")DataSource ds){
        DataSourceTransactionManager tx = new DataSourceTransactionManager();
        tx.setDataSource(ds);
        return tx;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    //注入的时候可以不用@Qualifier("druidDataSource")注解
    @Primary
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverclass);//如果不配置druid会根据url自动识别dbType，然后选择相应的driverClassName
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //以上只是配置了参数,并没有创建连接池,在这个类的init()中完成了连接池的创建
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效
        dataSource.setTestOnBorrow(false);//借用连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        dataSource.setTestOnReturn(false);//归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        //连接空闲时检测，如果连接空闲时间大于timeBetweenEvictionRunsMillis指定的毫秒，执行validationQuery指定的SQL来检测连接是否有效
        dataSource.setTestWhileIdle(true);//如果检测失败，则连接将被从池中去除
        dataSource.setTimeBetweenEvictionRunsMillis(60 * 1000);//1分钟
        // illegal initialSize 16, maxActive 8
        dataSource.setMaxActive(16);
        // int cpuCount=Runtime.getRuntime().availableProcessors();
        dataSource.setInitialSize(cpuCount);
        return dataSource;
    }


    @Bean // IOC注解 托管第三方bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    public DataSource dbcpDataSource(){
        BasicDataSource dataSource  = new BasicDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
