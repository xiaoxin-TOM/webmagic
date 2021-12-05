package com.atguigu.service;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBook(Integer id);
    public void updateBook(Book book);
    public Book queForBook(Integer id);
    public List<Book> queBooks();
}
