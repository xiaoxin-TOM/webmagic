package com.web.manger;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.User;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookMangerServlet extends BaseServlet {
    BookServiceImpl bookService = new BookServiceImpl();


    public void list(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException {
        List<Book> books = bookService.queBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/html/bookmanger.jsp").forward(req,reps);
    }
    public void add(HttpServletRequest req, HttpServletResponse reps) throws IOException {
        Book book  = WebUtils.toBean(req,new Book());
        bookService.addBook(book);
        reps.sendRedirect(req.getContextPath()+"/bookmangerservlet?action=list");
    }
    public void delete(HttpServletRequest req,HttpServletResponse reps) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.deleteBook(id);
        reps.sendRedirect(req.getContextPath()+"/bookmangerservlet?action=list");
    }
}
