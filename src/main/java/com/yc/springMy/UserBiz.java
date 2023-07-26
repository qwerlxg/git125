package com.yc.springMy;

public interface UserBiz {
    void addUser(String name);
}
class UserBizImpl implements UserBiz {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(String name) {
        // 委托UserDao进行数据库操作
        userDao.add(name);
    }
}