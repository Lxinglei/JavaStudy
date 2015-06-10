package cn.meteor.bookstore.order.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.meteor.bookstore.cart.domain.Cart;
import cn.meteor.bookstore.cart.domain.CartItem;
import cn.meteor.bookstore.order.domain.Order;
import cn.meteor.bookstore.order.domain.OrderItem;
import cn.meteor.bookstore.order.service.OrderException;
import cn.meteor.bookstore.order.service.OrderService;
import cn.meteor.bookstore.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by meteor on 15/6/9.
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderService();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        Order order = new Order();
        order.setOid(CommonUtils.uuid());
        order.setOrdertime(new Date());
        order.setState(1);
        order.setOwner((User)request.getSession().getAttribute("session_user"));
        order.setTotal(cart.getTotal());

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (CartItem cartItem : cart.getCartItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setIid(CommonUtils.uuid());
            orderItem.setBook(cartItem.getBook());
            orderItem.setCount(cartItem.getCount());
            orderItem.setOrder(order);
            orderItem.setSubtotal(cartItem.getSubTotal());
            orderItems.add(orderItem);
        }

        order.setOrderItemList(orderItems);
        cart.clear();
        orderService.add(order);
        request.setAttribute("order", order);
        return "f:/jsps/order/desc.jsp";
    }

    public String myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("session_user");
        List<Order> orderList = orderService.myOrders(user.getUid());
        request.setAttribute("orderList", orderList);
        return "f:/jsps/order/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        Order order = orderService.load(oid);
        request.setAttribute("order", order);
        return "f:/jsps/order/desc.jsp";
    }

    public String confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        try {
            orderService.confirm(oid);
            request.setAttribute("msg", "确认收货成功");
            return "f:/jsps/msg.jsp";
        } catch (OrderException e) {
            request.setAttribute("msg", e.getMessage());
            return "f:/jsps/msg.jsp";
        }
    }


}
