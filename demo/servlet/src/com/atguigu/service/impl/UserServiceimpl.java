package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

import javax.swing.tree.TreeCellEditor;
import java.sql.SQLException;

public class UserServiceimpl implements UserService {
    UserDaoImpl userdao= new UserDaoImpl();
    @Override
    public User login(User user) {
       return userdao.queUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void resigter(User user) {
            userdao.insertUser(user);
    }
//false用户不存在，true用户存在
    @Override
    public boolean nameExist(String name) {
        if (userdao.queUserName(name)==null){
            return false;
        }else {
            return true;
        }

    }
}
