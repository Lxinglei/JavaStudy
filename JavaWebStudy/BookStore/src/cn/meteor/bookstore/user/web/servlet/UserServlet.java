package cn.meteor.bookstore.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import cn.meteor.bookstore.cart.domain.Cart;
import cn.meteor.bookstore.user.domain.User;
import cn.meteor.bookstore.user.service.UserException;
import cn.meteor.bookstore.user.service.UserService;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by metror on 15/5/22.
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();

    public String regist(HttpServletRequest request, HttpServletResponse response) {
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        form.setUid(CommonUtils.uuid());
        form.setCode(CommonUtils.uuid() + CommonUtils.uuid());
        form.setState(false);

        Map<String, String> errors = new HashMap<String, String>();

        String username = form.getUsername();
        if (username == null || username.trim().isEmpty())
            errors.put("username", "用户名不能为空");
        else if (username.trim().length() > 10 || username.trim().length() < 2)
            errors.put("username", "用户名长度不符合规范");

        String password = form.getPassword();
        if (password == null || password.trim().isEmpty())
            errors.put("password", "密码不能为空");
        else if (password.trim().length() > 18 || password.trim().length() < 2)
            errors.put("password", "密码长度不符合规范");

        String email = form.getEmail();
        if (email == null || email.trim().isEmpty())
            errors.put("email", "邮箱不能为空");
        else if (!email.trim().matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"))
            errors.put("email", "邮箱格式错误");

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "f:/jsps/user/regist.jsp";
        }

        try {
            userService.regits(form);
            Properties props = new Properties();
            /**
             * 加载配置文件
             */
            props.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
            /**
             * 获取配置文件里的属性
             */
            String host = props.getProperty("host");
            String uname = props.getProperty("uname");
            String passwd = props.getProperty("passwd");
            String from = props.getProperty("from");
            String subject = props.getProperty("subject");
            String content = props.getProperty("content");
            content = MessageFormat.format(content, form.getCode());    //替换第一个占位符
            //对标题进行编码
            /**
             * 获取收件人
             * 发送激活邮件
             */
            String to = form.getEmail();
            Session session = MailUtils.createSession(host, uname, passwd);
            System.setProperty("mail.mime.charset","UTF-8");
            Mail mail = new Mail(from, to, subject, new String(content.getBytes("ISO-8859-1"), "utf-8"));
            MailUtils.send(session, mail);

            request.setAttribute("msg", "恭喜,注册成功,请尽快去邮箱激活!");
            return "f:/jsps/msg.jsp";
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", form);
            return "f:/jsps/msg.jsp";
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    public String active(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        try {
            userService.active(code);
            request.setAttribute("msg", "激活成功， 请登录");
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
        }
        return "f:/jsps/msg.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response){
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        try {
            User user = userService.login(form);
            request.getSession().invalidate();
            request.getSession().setAttribute("session_user", user);
            request.getSession().setAttribute("cart", new Cart());
            return "r:/index.jsp";
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", form);
            return "f:/jsps/user/login.jsp";
        }
    }

    public String quit(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        return "f:/jsps/user/login.jsp";
    }

}
