package com.yc.springtest1.springtest01biz;

import com.yc.springtest1.springtest01dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserBizImpl implements UserBiz{
    //将dao层的对象注入到biz DI依赖注入（将spring容器中托管的userdao的对象传到此处）
    @Resource(name="userDaoImpl") //由spring容器根据 id=userDaoImpl到容器找这个实例 并注入

    //第二种方法
    // @Autowired
    // @Qualifier("userDaoImpl")
    private UserDao userDao;
    public void UserBizImpl(){
        System.out.println("userDaoImpl的构造");
    }

    @Override
    public void add(String uname) {
        userDao.add(uname);
    }
}
