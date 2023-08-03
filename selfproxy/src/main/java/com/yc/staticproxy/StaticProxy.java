package com.yc.staticproxy;

public class StaticProxy implements OrderBiz{
    //目标类的引用，利用setXxx,或者构造方法  注入
    private OrderBiz orderBiz;

    public StaticProxy(OrderBiz orderBiz) {
        this.orderBiz = orderBiz;
    }

    @Override
    public void addOrder(int pid, int num) {
        //前置增强
        showHello();
        this.orderBiz.addOrder(pid,num);
        //后置增强
        showBye();
    }

    @Override
    public void findOrder() {

    }

    private void showBye() {
        System.out.println("bye");
    }

    private void showHello() {
        System.out.println("hello");
    }
}
