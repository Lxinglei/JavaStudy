package cn.meteor.bookstore.order.dao;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.meteor.bookstore.book.domain.Book;
import cn.meteor.bookstore.order.domain.Order;
import cn.meteor.bookstore.order.domain.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by meteor on 15/6/9.
 */
public class OrderDao {
    private QueryRunner queryRunner = new TxQueryRunner();
    public void add(Order order){
        try {
            String sql = "INSERT INTO orders VALUES(?, ?, ?, ?, ?, ?)";
            Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
            Object[] params = {order.getOid(), timestamp, order.getTotal(), order.getState(), order.getOwner().getUid(), order.getAddress()};
            queryRunner.update(sql, params);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addOrderItems(List<OrderItem> orderItemList){
        try {
            String sql = "INSERT INTO orderitem VALUES(?, ?, ?, ?, ?)";
            Object[][] params = new Object[orderItemList.size()][];
            for (int i = 0; i <orderItemList.size(); i++) {
                OrderItem orderItem = orderItemList.get(i);
                params[i] = new Object[]{orderItem.getIid(), orderItem.getCount(),
                        orderItem.getSubtotal(), orderItem.getOrder().getOid(),
                        orderItem.getBook().getBid()};
            }
            queryRunner.batch(sql, params);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Order> findByUid(String uid) {
        String sql = "SELECT * FROM orders WHERE uid=?";
        try {
            List<Order> orderList = queryRunner.query(sql, new BeanListHandler<Order>(Order.class), uid);
            for (Order order : orderList){
                loadOrderItems(order);
            }
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadOrderItems(Order order) {
        String sql = "SELECT * FROM orderitem i, book b WHERE i.bid=b.bid and i.oid=?";
        try {
            List<Map<String, Object>> mapList = queryRunner.query(sql, new MapListHandler(), order.getOid());

            List<OrderItem> orderItemList = toOrderItemList(mapList);

            order.setOrderItemList(orderItemList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        for (Map<String, Object> map : mapList){
            OrderItem orderItem = toOrderItem(map);
            orderItemList.add(orderItem);
        }
        return orderItemList;
    }

    private OrderItem toOrderItem(Map<String, Object> map) {
        OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
        Book book = CommonUtils.toBean(map, Book.class);
        orderItem.setBook(book);
        return orderItem;
    }

    public Order findByOid(String oid) {
        String sql = "SELECT * FROM orders WHERE oid=?";
        try {
            Order order = queryRunner.query(sql, new BeanHandler<Order>(Order.class), oid);
            loadOrderItems(order);
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getStateByOid(String oid){
        String sql = "SELECT state FROM orders WHERE oid=?";
        try {
            Order order = queryRunner.query(sql, new BeanHandler<Order>(Order.class), oid);
            return order.getState();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String oid, int state){
        String sql = "UPDATE orders SET state=? WHERE oid=?";
        Object[] params = {4, oid};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
mysql> DESC orderitem;
+----------+---------------+------+-----+---------+-------+
| Field    | Type          | Null | Key | Default | Extra |
+----------+---------------+------+-----+---------+-------+
| iid      | char(32)      | NO   | PRI | NULL    |       |
| count    | int(11)       | YES  |     | NULL    |       |
| subtotal | decimal(10,0) | YES  |     | NULL    |       |
| oid      | char(32)      | YES  | MUL | NULL    |       |
| bid      | char(32)      | YES  | MUL | NULL    |       |
+----------+---------------+------+-----+---------+-------+
 */