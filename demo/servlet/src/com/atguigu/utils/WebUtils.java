package com.atguigu.utils;

import com.atguigu.pojo.User;
import com.sun.deploy.net.HttpRequest;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class WebUtils {
    public static <T> T toBean(HttpServletRequest req,T user){
        try {
            BeanUtils.populate(user,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }
}
