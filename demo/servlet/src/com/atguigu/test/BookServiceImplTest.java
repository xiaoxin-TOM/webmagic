package com.atguigu.test;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    BookServiceImpl bookService = new BookServiceImpl();
    @Test
    public void addBook() {

        Book book =new Book(67,"动漫迷","不理不理",new BigDecimal(23.9),330,12,null);
    bookService.addBook(book);
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(22);
    }

    @Test
    public void updateBook() {
        Book book =new Book(23,"动漫迷","不理",new BigDecimal(23.9),330,12,null);
    bookService.updateBook(book);
    }

    @Test
    public void queForBook() {
        System.out.println(bookService.queForBook(23));
    }

    @Test
    public void queBooks() {
        for(Book book:bookService.queBooks()){
            System.out.println(book);
        }
    }
}