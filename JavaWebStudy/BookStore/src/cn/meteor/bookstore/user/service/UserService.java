package cn.meteor.bookstore.user.service;

import cn.itcast.jdbc.TxQueryRunner;
import cn.meteor.bookstore.user.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by metror on 15/5/22.
 */
public class UserService{
    private UserDao userDao = new UserDao();
}
