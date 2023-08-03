package com.yc.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// @Component
// @Aspect
public class MyAspects {
    //切入点表达式：正则表达式  筛选 目标类哪些方法增强
    //* ：
    //.. :代表 0或者1
    @Pointcut("execution(* com.yc.biz.*.make*(..))")
    private void a(){}

    /**
     *
     */
   // @Before("execution(* com.yc.biz.*.make*(..))")
    @Before("a()")
    public void recordTime(){
        Date data = new Date();
        System.out.println("=============>>>下单当前时间:"+data);
    }
    @AfterReturning("a()")
    public void sendEmail(){
        System.out.println("发邮件...");
    }

    @AfterReturning("a()")
    public void recordParams(JoinPoint jp){
        //记录连接点make*() 中的参数信息 male() 就称为JoinPoint
        //从jp中可以取出一些信息 make*()方法的信息
        System.out.println("增强的方法为："+jp.getSignature());
        System.out.println("增强的目标类为："+jp.getTarget());
        System.out.println("参数:");
        Object[] params = jp.getArgs();
        for (Object o:params){
            System.out.println(o);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Pointcut("execution(* com.yc.biz.*.findOrderId(String))")
    private void b(){}

    //TODO 正常访问redis 商品名 次数    正常用redis 这不用
    private Map<String,Object> map = new ConcurrentHashMap<>();
    //统计每个商品查询的次数
    @Before("b()")
    public void recordPnameCount(JoinPoint jp) {
        Object[] objs = jp.getArgs();
        String pname = (String) objs[0];
        Long num = 1L;
        if (map.containsKey(pname)) {
            num = (Long) map.get(pname);
            num++;
        }
        map.put(pname, num);
        System.out.println("统计结果：" + map);
    }

    ////////////////////////////////////////////////////////////////////////
    //查询是同一个商品名有不同的返回值 pid 统计频率
    @Pointcut("execution(* com.yc.biz.*.findPid(String))")
    private void c(){}
    private Map<String,Object> map1 = new ConcurrentHashMap<>();
    //统计每个商品编号查询的次数
    @AfterReturning(pointcut = "c()",returning = "retValue")
    public void recordPnameCount1(JoinPoint jp,int retValue) {
        Object[] objs = jp.getArgs();
        String pname = (String) objs[0];
        Long num = 1L;
        if (map1.containsKey(pname)) {
            num = (Long) map1.get(pname);
            num++;
        }
        map1.put(pname+":"+retValue, num);
        System.out.println("统计结果：" + map1);
    }

    ////////////////////////////////////////异常处理////
    @AfterThrowing(pointcut = "a()",throwing = "ex")
    public void recordException(JoinPoint jp, RuntimeException ex){
        System.out.println("***************异常****************");
        System.out.println(ex.getMessage());
        System.out.println(jp.getArgs()[0]+"\t"+jp.getArgs()[1]);
        System.out.println("***********************************");
    }

    ////////////////////////////////////////查询很慢统计时间////
     @Pointcut("execution(* com.yc.biz.*.find*(..))")
      private void d(){}
      @Around("d()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp)throws Throwable{
        long start = System.currentTimeMillis();
        Object retval = pjp.proceed(); // 返回find*()
          long end = System.currentTimeMillis();
          System.out.println("方法执行时间："+(end-start));
          return retval;
      }
}

