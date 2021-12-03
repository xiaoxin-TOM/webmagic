package com.web;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceimpl;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is get method");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);

        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getRealPath("/src"));


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config);
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username,password,null);
        //登陆成功
        if (userServiceimpl.login(user) != null) {
            System.out.println("登陆成功");
            req.getRequestDispatcher("/html/login_success.jsp").forward(req, resp);
        } else {
        //登陆失败
            req.setAttribute("msg","登陆失败<br>用户名或者密码错误");
            req.setAttribute("username",username);
            System.out.println("登陆失败");
            req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
        }
    }
}
