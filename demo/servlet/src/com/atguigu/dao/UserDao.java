package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {
    public User queUserName(String name);
    public User queUserNameAndPassword(String name,String password);
    public int insertUser(User user);
}
