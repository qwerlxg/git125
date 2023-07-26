package com.yc.springMy;

public interface UserDao {
    void add(String uname);
}
class JdbcDao implements UserDao {
    @Override
    public void add(String uname) {
        // 实现具体的数据库操作，这里只是示例，省略具体实现
        System.out.println("Add user: " + uname);
    }
}