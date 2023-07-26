package com.yc.springtest1.springtest01;

import com.yc.springMy.UserDao;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaolmpl implements UserDao {

    public UserDaolmpl(){
        System.out.println("UserDaolmpl类的构造...");
    }
    @Override
    public void add(String uname) {
        System.out.println("添加了:"+uname);
    }
}
