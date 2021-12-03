package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

public class bookDaoTest {
    BookDaoImpl bookDao = new BookDaoImpl();
    @Test
    public void addBook(){
        System.out.println(bookDao.addBook(new Book(67,"小新的书","珠江",new BigDecimal(13.4),330,12,null)));
    }
    @Test
    public void  deleteBookById() {
        System.out.println(bookDao.deleteBookById(23));
    }
    @Test
    public void upBook(){
        System.out.println(bookDao.upBook(new Book(21,"小新的书书本","珠江",new BigDecimal(13.4),330,12,"/path/com/impl")));
    }
    @Test
    public void que(){
        System.out.println(bookDao.queBookById(12).toString());
    }
    @Test
    public void queBooks(){
        for(Book book:bookDao.queBooks()){
            System.out.println(book);
        };
    }
}
