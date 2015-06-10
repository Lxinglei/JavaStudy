package cn.meteor.bookstore.category.web.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.meteor.bookstore.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by meteor on 15/6/6.
 */
public class CateGoryServlet extends BaseServlet{
    CategoryService categoryService = new CategoryService();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categoryList", categoryService.findAll());
        return "f:/jsps/left.jsp";
    }
}
