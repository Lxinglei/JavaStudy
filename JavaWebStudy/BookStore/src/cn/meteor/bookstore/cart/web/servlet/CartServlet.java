package cn.meteor.bookstore.cart.web.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.meteor.bookstore.book.domain.Book;
import cn.meteor.bookstore.book.service.BookService;
import cn.meteor.bookstore.cart.domain.Cart;
import cn.meteor.bookstore.cart.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by meteor on 15/6/8.
 */
public class CartServlet extends BaseServlet {
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        String bid = request.getParameter("bid");
        Book book = new BookService().load(bid);
        int count = Integer.parseInt(request.getParameter("count"));
        CartItem cartItem = new CartItem();
        cartItem.setCount(count);
        cartItem.setBook(book);

        cart.add(cartItem);

        return "f:/jsps/cart/list.jsp";
    }

    public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        cart.clear();
        return "f:/jsps/cart/list.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        cart.delete(bid);
        return "f:/jsps/cart/list.jsp";
    }


}
