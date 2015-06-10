package cn.meteor.bookstore.cart.domain;

import cn.meteor.bookstore.book.domain.Book;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by meteor on 15/6/8.
 */
public class CartItem {

    private Book book;
    private int count;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubTotal(){
        BigDecimal b1 = new BigDecimal(count+"");
        BigDecimal b2 = new BigDecimal(book.getPrice()+"");
        return b1.multiply(b2).doubleValue();
    }

 }
