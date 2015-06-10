package cn.meteor.bookstore.book.dao;

import cn.itcast.jdbc.TxQueryRunner;
import cn.meteor.bookstore.book.domain.Book;
import cn.meteor.bookstore.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by meteor on 15/6/6.
 */
public class BookDao {
    QueryRunner queryRunner = new TxQueryRunner();
    public List<Book> findAll(){
        String sql = "SELECT * FROM book";
        try {
            return queryRunner.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findByCategory(Category category){
        String sql = "SELECT * FROM book WHERE cid=?";
        try {
            return queryRunner.query(sql, new BeanListHandler<Book>(Book.class), category.getCid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book findByBid(String bid) {
        String sql = "SELECT * FROM book WHERE bid=?";
        try {
            return queryRunner.query(sql, new BeanHandler<Book>(Book.class), bid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
