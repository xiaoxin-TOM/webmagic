package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBook(Integer id);
    public void updateBook(Book book);
    public Book queForBook(Integer id);
    public List<Book> queBooks();

    Page page(int pageNo, int pageSize);
}
