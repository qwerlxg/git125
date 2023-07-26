package com.yc.springtest3.system;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *   1. 能存大量对象( 大学生Bmi |...)  => 集合
 *     2. 测量的接口     => 具体怎么测，由用户决定
 *     3. 筛选的接口    =>  具体怎么筛选，由用户决定.
 *     4. 返回最大值对象，最小值对象....
 */
@Component
public class Container<T> {
    private List<T> objs = new ArrayList<T>();

    //TODO 用spring完成DI
    @Resource(name = "bmiMeasure") //@Resource 通过名称或类型来查找并注入指定的资源或 bean。
    private Measure measure;
    @Resource(name = "bmiFilter")
    private ContainerFilter filter;


    private T max;
    private T min;
    private double avg;
    private double sum;

    /**
     * 添加对象方法
     */
    public void add( T t){
        //判断t 是否为合格  调用筛选实现
        if (filter!=null){
            if (filter.doFilter(t)==false){
                return;
            }
        }
        //添加到 object
        objs.add(t);
        //判断大小 记录 max min avg +++》调用 measure实现
        if (objs.size()==1){
            max=t;
            min=t;
        }else {
            //测出值  判断大小
            double val = this.measure.doMeasure(t);
            double maxval = this.measure.doMeasure(max);
            double minval = this.measure.doMeasure(min);
            if (val>maxval){
                max=t;
            }
            if (val>minval){
                min=t;
            }
        }
        sum+=measure.doMeasure(t);
        avg=sum/objs.size();
    }


    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }
    /**
     * 有效的测量   对象有多少个
     */
    public int size(){
        return objs.size();
    }
    /**
     * 复位
     */
    public  void clearAll(){
        objs=new ArrayList<>();
        measure=null;
        filter=null;
        max=null;
        min=null;
        avg=0;
    }
}
