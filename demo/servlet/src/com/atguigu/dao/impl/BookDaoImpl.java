package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book (name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer bookId) {
        String sql = "delete from t_book where id = ?";
        return update(sql,bookId);
    }

    @Override
    public int upBook(Book book) {
        String sql = "update t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id =?";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queBookById(Integer bookid) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book where id = ?";

        return (Book) queForOne(sql,Book.class,bookid);
    }

    @Override
    public List<Book> queBooks() {
        String sql = "select name,price,author,sales,stock,img_path imgPath from t_book";
        List<Book> list = query(sql,Book.class);
        return list;
    }
}
