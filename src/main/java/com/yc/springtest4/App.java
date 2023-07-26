package com.yc.springtest4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        //AnnotationConfigApplicationContext  读取注解的类，生成容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);//Config.class是一个带有@Configuration注解的配置类，用于定义应用程序的Spring配置。
        DataSource ds = (DataSource) ac.getBean("myDataSource");
        Connection con = ds.getConnection();
        System.out.println(con);
    }
}
