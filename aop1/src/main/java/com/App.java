package com;

import com.yc.Config;
import com.yc.biz.OrderBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        OrderBiz ob =  ac.getBean(OrderBiz.class);
        //ob.findOrderId("apple");
        //ob.findPid("apple");
        //ob.makeOrder(1,99);
        // ob.findPid("apple");
        // ob.findPid("apple");
        // ob.findPid("apple");
        // ob.findPid("apple");
        // ob.findPid("pear");
        ob.findPid("apple");

    }
}
