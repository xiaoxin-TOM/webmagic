package com.atguigu.dao;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    //增删改语句
    //返回-1，说明执行失败，返回其他值为影响的行数
    public int update(String sql, Object... arg) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, arg);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    public <T> T queForOne(String sql, Class<T> tClass, Object... arg) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(tClass), arg);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    public <T> List<T> query(String sql, Class<T> tClass, Object... arg) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(tClass), arg);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    public Object queForOneValue(String sql, Object... arg) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), arg);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }


//查询学习
//    public <User>User Query(BeanHandler<User> type,int  ...arg) {
//        Connection conn = JdbcUtils.getConnection();
//        try {
//            User user = queryRunner.query(conn, "select id,username,password,email from t_user where id = ?", type, arg);
//            return user;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("meisoudao");
//        }finally {
//            JdbcUtils.close(conn);
//        }
//        return null;
//    }
//查询学习
//    public void Query2() {
//        Connection conn = JdbcUtils.getConnection();
//        BeanListHandler<User> beanListHandler = new BeanListHandler<>(User.class);
//        try {
//            List<User> userList= queryRunner.query(conn,"select * from t_user where id > ?",beanListHandler,2);
//            userList.forEach (System.out::println);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            JdbcUtils.close(conn);
//        }
//    }
    @Test
    public void testing(){
//        new BaseDao().Query2();
        //dao.Query("select * from t_user where id = ",handler,"2" );
        //Query("select * from t_user where id = ",handler,2 );
        //new BaseDao().Insert("insert into t_user(`username`,`password`,`email`) values (?,?,?)","at","fff","fi@foxmail.com");
    }


}