package cn.meteor.bookstore.user.web.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.meteor.bookstore.user.service.UserService;

/**
 * Created by metror on 15/5/22.
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();
}
