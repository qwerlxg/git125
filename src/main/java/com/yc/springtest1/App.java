package com.yc.springtest1;

import com.yc.springtest1.springtest01.Config;
import com.yc.springtest1.springtest01biz.UserBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext containner = new AnnotationConfigApplicationContext(Config.class);

        UserBiz ub = (UserBiz) containner.getBean("userBizImpl");
        ub.add("XG");
    }
}
