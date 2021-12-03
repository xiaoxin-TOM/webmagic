package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceimpl;
import com.atguigu.utils.JdbcUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class JdbcUtilsTest {
    @Test
    public void beanTest(){
        User user = new User();
        try {
            Map map = new HashMap();
            map.put("username","tom");
            map.put("password","333");
            map.put("email","xiaoxintom@qq.com");
            map.put("action","login");
            map.put("code","nbps");
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);

    }
    @Test
    public void service(){
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        if (userServiceimpl.login(new User("tom","333","222@qq.com"))==null){
            System.out.println("用户不存在");
        }else {
            System.out.println("用户存在");
        }
    }
    @Test
    public void serviceregister(){
        UserServiceimpl userServiceimpl=new UserServiceimpl();
        User user=new User("tomone","2221","222@qq.com");
        if (!userServiceimpl.nameExist(user.getUsername())){
            userServiceimpl.resigter(user);
            System.out.println("注册成功");
        }else {
            System.out.println("用户存在");
        }


    }




    @Test
    public void register() {
        UserDao userDaoip=  new UserDaoImpl();
        User user= userDaoip.queUserName("3333");
        if(user==null){
            System.out.println("用户名不存在可以注册");
        }else {
            System.out.println("用户名存在，不可以注册");
        }
    }
    @Test
    public void login(){
        UserDao userDaoip = new UserDaoImpl();
        User user = userDaoip.queUserNameAndPassword("tom","333");
        if(user==null){
            System.out.println("用户名或者密码错误");
        }else {
            System.out.println("登陆成功");
        }
    }
    @Test
    public void resgiter2(){
        User user=new User("ttt","333","123@jkl.com");
        UserDao userDaoip = new UserDaoImpl();
        userDaoip.insertUser(user);
    }

    @Test
    public void test1(){
        for(int i=0;i<100;i++){
            Connection connection=JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }

    }
}
