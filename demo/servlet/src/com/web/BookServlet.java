package com.web;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        req.setAttribute("username",username);
        if("nbps".equals(req.getParameter("code"))){
            if (!userServiceimpl.nameExist(req.getParameter("username"))){
            User user = new User(username,password,email);
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
    }
}
