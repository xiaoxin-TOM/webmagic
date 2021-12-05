package com.atguigu.service.impl;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.upBook(book);
    }

    @Override
    public Book queForBook(Integer id) {

        return bookDao.queBookById(id);
    }

    @Override
    public List<Book> queBooks() {
        return bookDao.queBooks();
    }

    @Override
    public Page page(int pageNo, int pageSize) {
        return null;
    }
}
