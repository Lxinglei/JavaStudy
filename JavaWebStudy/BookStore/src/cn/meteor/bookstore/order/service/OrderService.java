package cn.meteor.bookstore.order.service;

import cn.itcast.jdbc.JdbcUtils;
import cn.meteor.bookstore.order.dao.OrderDao;
import cn.meteor.bookstore.order.domain.Order;
import cn.meteor.bookstore.user.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by meteor on 15/6/9.
 */
public class OrderService {
    private OrderDao orderDao = new OrderDao();
    public void add(Order order){
        try {
            JdbcUtils.beginTransaction();
            orderDao.add(order);
            orderDao.addOrderItems(order.getOrderItemList());
            JdbcUtils.commitTransaction();
        } catch (Exception e){
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException(e);
        }
    }

    public List<Order> myOrders(String uid) {
        return orderDao.findByUid(uid);
    }

    public Order load(String oid) {
        return orderDao.findByOid(oid);
    }

    public void confirm(String oid) throws OrderException{
        if (orderDao.getStateByOid(oid) != 3)
            throw new OrderException("确认收货失败");

        orderDao.updateState(oid, 3);
    }
}
