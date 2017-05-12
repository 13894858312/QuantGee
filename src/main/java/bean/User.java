package bean;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/12.
 */
public class User {

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
