package com.yc.springtest4;

import com.yc.springtest4.user.BankAccount;
import com.yc.springtest4.user.BankAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        //AnnotationConfigApplicationContext  读取注解的类，生成容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);//Config.class是一个带有@Configuration注解的配置类，用于定义应用程序的Spring配置。
        BankAccountDao bad = (BankAccountDao) ac.getBean("bankAccountDao");
        List<BankAccount>list = bad.findAll();
        for (BankAccount ba:list){
            System.out.println(ba);
        }
    }
}
