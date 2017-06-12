package vo.user;

/**
 * Created by Mark.W on 2017/5/11.
 * 账户信息的vo
 */
public class AccountVO {
    private String accountID;
    private String password;
    private String formerPassword;  //修改密码用，传递修改前的密码
    private String registerDate;    //注册时该信息才需要填写
    private int isLogin;              //0表示状态登出状态 1表示登陆状态

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    public String getFormerPassword() {
        return formerPassword;
    }

    public void setFormerPassword(String formerPassword) {
        this.formerPassword = formerPassword;
    }
}
