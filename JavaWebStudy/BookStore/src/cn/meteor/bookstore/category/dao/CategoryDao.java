package cn.meteor.bookstore.category.dao;

import cn.itcast.jdbc.TxQueryRunner;
import cn.meteor.bookstore.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by meteor on 15/6/6.
 */
public class CategoryDao {
    QueryRunner queryRunner = new TxQueryRunner();

    public List<Category> findAll() {
        String sql = "SELECT * FROM category";
        try {
            return queryRunner.query(sql, new  BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
