package vo;

/**
 * Created by Mark.W on 2017/5/9.
 * 管理员管理用户 可以获取的用户信息
 */
public class UserAccoutForm {
    private String AccountID;		//账号
    private String registerDate;    //注册日期
    private String userName;		//用户昵称
    private String phoneNumber;		//电话号码

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
