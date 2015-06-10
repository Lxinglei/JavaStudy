package cn.meteor.bookstore.book.web.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.meteor.bookstore.book.domain.Book;
import cn.meteor.bookstore.book.service.BookService;
import cn.meteor.bookstore.category.domain.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by meteor on 15/6/6.
 */
public class BookServlet extends BaseServlet {
    BookService bookService = new BookService();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookService.findAll();
        request.setAttribute("bookList", bookList);
        return "f:/jsps/book/list.jsp";
    }

    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        category.setCid(request.getParameter("cid"));
        List<Book> bookList = bookService.findByCategory(category);
        request.setAttribute("bookList", bookList);
        return "f:/jsps/book/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Book book = bookService.load(bid);
        request.setAttribute("book", book);
        return "f:/jsps/book/desc.jsp";
    }
}
