package com.yc.springtest1;

import com.yc.springtest1.springtest01.Config;

import com.yc.springtest1.springtest01biz.UserBiz;
import com.yc.springtest1.springtest01dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext containner = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(containner);

         UserDao ud = (UserDao) containner.getBean("userDaoImpl");
         ud.add("XG");

        UserBiz ub = (UserBiz) containner.getBean("userBizImpl");
        ub.add("XG1");
    }
}
