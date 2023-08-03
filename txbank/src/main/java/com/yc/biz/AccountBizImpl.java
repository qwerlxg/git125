package com.yc.biz;

import org.springframework.stereotype.Service;

@Service
public class AccountBizImpl implements AccountBiz{
    @Override
    public void addAcount(int accountid, double money) {
        System.out.println("添加用户："+accountid);
    }
}
