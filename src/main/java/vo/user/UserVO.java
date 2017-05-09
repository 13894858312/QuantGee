package vo.user;

/**
 * Created by Mark.W on 2017/5/9.
 * 用户信息的vo
 */
public class UserVO {

    private String AccountID;		//账号
    private String userName;		//用户昵称
    private String phoneNumber;		//电话号码

    public UserVO() {}

    /**
     * @param accountID 账号
     * @param userName 用户昵称
     * @param phoneNumber 电话号码
     */
    public UserVO(String accountID, String userName, String phoneNumber) {
        AccountID = accountID;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

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
