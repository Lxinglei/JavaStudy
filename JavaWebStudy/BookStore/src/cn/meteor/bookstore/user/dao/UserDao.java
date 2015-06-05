package cn.meteor.bookstore.user.dao;

import cn.itcast.jdbc.TxQueryRunner;
import cn.meteor.bookstore.user.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by metror on 15/5/22.
 */
public class UserDao {
    private QueryRunner queryRunner = new TxQueryRunner();
    public User findByUsername(String username){
        try {
            String sql = "SELECT * FROM tb_user where username=?";
            return queryRunner.query(sql, new BeanHandler<User>(User.class), username);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public User findByEmail(String email){
        try {
            String sql = "SELECT * FROM tb_user where email=?";
            return queryRunner.query(sql, new BeanHandler<User>(User.class), email);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void add(User user){
        try {
            String sql = "INSERT INTO tb_user VALUES(?, ?, ?, ?, ?, ?)";
            Object[]  params = {user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.getCode(), user.getState()};
            queryRunner.update(sql, params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public User findByCode(String code){
        try {
            String sql = "SELECT * FROM tb_user WHERE code=?";
            return queryRunner.query(sql, new BeanHandler<User>(User.class), code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String uid, boolean state){
        try {
            String sql = "UPDATE tb_user SET state=? WHERE uid=?";
            queryRunner.update(sql, state, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * private String uid; //用户id
     private String username;    //用户名
     private String password;    //密码
     private String email;   //邮箱
     private String code;    //验证码
     private Boolean state;  //用户激活状态
     */
}
