package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    public User login(User user);
    public void resigter(User user);
    public boolean nameExist(String name);
}
