package com.yc.dao;

import org.ycframework.annotation.YcLazy;
import org.ycframework.annotation.YcRepository;
import org.ycframework.annotation.YcScope;

@YcRepository
// @YcLazy
// @YcScope(value = "")
public class UserDaoImpl implements UserDao{

    @Override
    public void add(String uname) {
        System.out.println("dao添加了"+uname);
    }
}
