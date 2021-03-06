package cn.meteor.bookstore.user.domain;

/**
 * Created by metror on 15/5/22.
 * User的领域对象
 * @author meteor
 */
public class User {
    private String uid; //用户id
    private String username;    //用户名
    private String password;    //密码
    private String email;   //邮箱
    private String code;    //验证码
    private Boolean state;  //用户激活状态

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
