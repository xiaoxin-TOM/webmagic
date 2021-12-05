package com.web.manger;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.pojo.User;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.ReplicateScaleFilter;
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
    public void getbook(HttpServletRequest req,HttpServletResponse reps) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.queForBook(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/html/edit.jsp").forward(req,reps);
    }
    public void edit(HttpServletRequest req,HttpServletResponse reps) throws IOException {
        Book book = WebUtils.toBean(req,new Book());
        bookService.updateBook(book);
        reps.sendRedirect(req.getContextPath()+"/bookmangerservlet?action=list");
    }
    public void page(HttpServletRequest req,HttpServletResponse reps) throws ServletException, IOException {
        int pageNo = 1;
        if(req.getParameter("pageNo")!=null){
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        }
        int pageSize = Page.PAGE_SIZE;
        if(req.getParameter("pageSize")!=null){
            pageSize = Integer.parseInt(req.getParameter("pageSize"));
        }
        Page<Book> page = bookService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/html/bookmanger.jsp").forward(req,reps);
    }
}
