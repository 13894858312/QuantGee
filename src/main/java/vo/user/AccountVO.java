package vo.user;

/**
 * Created by Mark.W on 2017/5/11.
 * 账户信息的vo
 */
public class AccountVO {
    private String accountID;
    private String password;
    private String registerDate;    //注册时该信息才需要填写

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
}
