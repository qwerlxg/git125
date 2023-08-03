package com.yc.springtest1.springtest01;

import com.yc.springtest1.springtest01dao.UserDao;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){
        System.out.println("UserDaolmpl类的构造...");
    }
    @Override
    public void add(String uname) {
        System.out.println("添加了:"+uname);
    }
}
