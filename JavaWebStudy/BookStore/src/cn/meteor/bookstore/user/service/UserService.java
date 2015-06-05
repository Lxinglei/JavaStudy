package cn.meteor.bookstore.user.service;

import cn.itcast.jdbc.TxQueryRunner;
import cn.meteor.bookstore.user.dao.UserDao;
import cn.meteor.bookstore.user.domain.User;
import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by metror on 15/5/22.
 */
public class UserService{
    private UserDao userDao = new UserDao();
    public void regits(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());
        if (user != null)
            throw new UserException("用户名已存在!");
        user = userDao.findByEmail(form.getEmail());
        if (user != null)
            throw new UserException("该邮箱已被注册!");

        userDao.add(form);
    }

    public void active(String code) throws UserException {
        User user = userDao.findByCode(code);
        if (user == null)
            throw new UserException("不存在此激活码!");
        if (user.getState())
            throw new UserException("该用户以进行过激活操作，不能重复激活");
        userDao.updateState(user.getUid(), true);
    }

    public User login(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());
        if (null == user)
            throw new UserException("该用户不存在!");
        if (!form.getPassword().equals(user.getPassword()))
            throw new UserException("密码错误!");
        if (!user.getState())
            throw new UserException("请先进行激活操作");
        return user;
    }
}
