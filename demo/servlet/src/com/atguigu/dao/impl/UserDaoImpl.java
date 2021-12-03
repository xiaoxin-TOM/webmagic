package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queUserName(String name) {
        String sql = "select * from t_user where username = ?";
        User user= (User) queForOne(sql,User.class,name);
        return user;
    }

    @Override
    public User queUserNameAndPassword(String name, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        User user= (User) queForOne(sql,User.class,name,password);
        return user;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user (username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
