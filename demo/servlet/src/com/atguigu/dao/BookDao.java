package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deleteBookById(Integer bookId);
    public int upBook(Book book);
    public Book queBookById(Integer bookid);
    public List<Book> queBooks();
}
