package cn.meteor.bookstore.cart.domain;

import cn.meteor.bookstore.book.domain.Book;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by meteor on 15/6/8.
 */
public class Cart {
    private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();

    public double getTotal(){
        BigDecimal total = new BigDecimal("0");
        for (CartItem cartItem : map.values()){
            BigDecimal subTotal = new BigDecimal(cartItem.getSubTotal()+"");
            total = total.add(subTotal);
        }
        return total.doubleValue();
    }
    public void add(CartItem cartItem){
        if (map.containsKey(cartItem.getBook().getBid())){
            cartItem.setCount(cartItem.getCount() + 1);
            map.put(cartItem.getBook().getBid(), cartItem);
        } else
            map.put(cartItem.getBook().getBid(), cartItem);
    }

    public void clear(){
        map.clear();
    }

    public void delete(String bid){
        map.remove(bid);
    }

    public Collection<CartItem> getCartItems() {
        return map.values();
    }

}

