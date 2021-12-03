package com.web;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceimpl;
import com.atguigu.utils.WebUtils;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private UserServiceimpl userServiceimpl = new UserServiceimpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user  = WebUtils.toBean(req,new User());
        //登陆成功
        if (userServiceimpl.login(user) != null) {
            System.out.println("登陆成功");
            req.getRequestDispatcher("/html/login_success.jsp").forward(req, resp);
        } else {
            //登陆失败
            req.setAttribute("msg","登陆失败<br>用户名或者密码错误");
            req.setAttribute("username",user.getUsername());
            System.out.println("登陆失败");
            req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
        }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user  =WebUtils.toBean(req,new User());
        req.setAttribute("username",user.getUsername());
        if("nbps".equals(req.getParameter("code"))){
            if (!userServiceimpl.nameExist(req.getParameter("username"))){
                userServiceimpl.resigter(user);
                req.getRequestDispatcher("/html/register_success.jsp").forward(req,resp);
            }else {
                //用户已经存在
                req.setAttribute("msg","用户已经存在");
                req.getRequestDispatcher("/html/register.jsp").forward(req,resp);
            }
        }else {
            //验证码失败
            req.setAttribute("msg","验证码错误");
            req.getRequestDispatcher("/html/register.jsp").forward(req,resp);
        }
    }
}
