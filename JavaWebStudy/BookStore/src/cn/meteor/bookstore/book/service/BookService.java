package cn.meteor.bookstore.book.service;

import cn.meteor.bookstore.book.dao.BookDao;
import cn.meteor.bookstore.book.domain.Book;
import cn.meteor.bookstore.category.domain.Category;

import java.util.List;

/**
 * Created by meteor on 15/6/6.
 */
public class BookService {
    BookDao bookDao = new BookDao();
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public List<Book> findByCategory(Category category){
        return bookDao.findByCategory(category);
    }

    public Book load(String bid) {
        return bookDao.findByBid(bid);
    }
}
