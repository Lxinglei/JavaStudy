package cn.meteor.bookstore.order.domain;

import cn.meteor.bookstore.book.domain.Book;

/**
 * Created by meteor on 15/6/9.
 */
public class OrderItem {
    private String iid;
    private int count;
    private double subtotal;
    private Order order;
    private Book book;

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
/*
iid      | char(32)      | NO   | PRI | NULL    |       |
| count    | int(11)       | YES  |     | NULL    |       |
| subtotal | decimal(10,0) | YES  |     | NULL    |       |
| oid      | char(32)      | YES  | MUL | NULL    |       |
| bid      | char(32)      | YES  | MUL | NULL    |       |
+----------+---------------+------+-----+---------+-------+
 */