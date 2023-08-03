package com.yc.springtest3.user;

import com.yc.springtest3.system.Measure;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;

@Component("bmiMeasure")
public class StudentBmiMeasure implements Measure {
    //算法放在用户里
    @Override
    public double doMeasure(Object obj) {
        if (obj == null){
            throw new RuntimeException("待测数据异常");
        }
        if (!(obj instanceof Student)){
            throw new RuntimeException("待测数据异常");
        }
        Student s = (Student)obj;
        return s.getWeight()/(s.getHeight()*s.getHeight());
    }
}
