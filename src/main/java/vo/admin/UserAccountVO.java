package vo.admin;

/**
 * Created by Mark.W on 2017/5/9.
 * 管理员管理用户 可以获取的用户信息
 */
public class UserAccountVO {
    private String AccountID;		//账号
    private String registerDate;    //注册日期
    private String userName;		//用户昵称
    private String phoneNumber;		//电话号码

    public UserAccountVO() {}

    /**
     * @param accountID 账号
     * @param registerDate 注册日期
     * @param userName 用户昵称
     * @param phoneNumber 电话号码
     */
    public UserAccountVO(String accountID, String registerDate, String userName, String phoneNumber) {
        AccountID = accountID;
        this.registerDate = registerDate;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

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
