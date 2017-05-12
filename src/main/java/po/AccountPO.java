package po;

/**
 * Created by PC on 2017/5/5.
 */
public class AccountPO {

    private String accountID;
    private String password;
    private String registerDate;
    private String identity;

    public AccountPO(){}

    /**
     *
     * @param accountID 用户ID
     * @param password 密码
     * @param registerDate 注册日期
     * @param identity 用户身份
     */
    public AccountPO(String accountID , String password , String registerDate , String identity){
        this.accountID = accountID;
        this.password = password;
        this.registerDate = registerDate;
        this.identity = identity;
    }

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
	
	public String getIdentity() {
		return identity;
	}
	
	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
