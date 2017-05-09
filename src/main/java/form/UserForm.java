package form;

/**
 * Created by Mark.W on 2017/5/9.
 */
public class UserForm {

    private String AccountID;		//账号
    private String userName;		//用户昵称
    private String phoneNumber;		//电话号码

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
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
