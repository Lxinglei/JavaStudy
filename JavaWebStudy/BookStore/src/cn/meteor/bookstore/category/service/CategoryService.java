package cn.meteor.bookstore.category.service;

import cn.meteor.bookstore.category.dao.CategoryDao;
import cn.meteor.bookstore.category.domain.Category;

import java.util.List;

/**
 * Created by meteor on 15/6/6.
 */
public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();

    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
