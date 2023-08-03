package com.yc.springtest3.user;

import com.yc.springtest3.system.ContainerFilter;
import org.springframework.stereotype.Component;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

@Component("bmiFilter")  //bmiFilter对象
public class StudentBimFilter implements ContainerFilter {

    //方法（算法）
    @Override
    public boolean doFilter(Object obj) {
        if (obj==null){
            return false;
        }
        if (!(obj instanceof Student)){   //instanceof操作符来检查对象obj是否是Student类的实例
            return false;
        }
        Student s = (Student) obj;
        if (s.getName()==null || "".equalsIgnoreCase(s.getName())){
            return false;
        }
        if (s.getHeight()<1 || s.getHeight()>2.7){
            return false;
        }
        if (s.getWeight()<30 || s.getWeight()>500){
            return false;
        }
        return true;
    }
}
