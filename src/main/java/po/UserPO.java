package po;

import java.util.ArrayList;

public class UserPO {

	private String accountID;		//账号
	private String userName;		//用户昵称
	private String phoneNumber;		//电话号码
	private ArrayList<String> collectStockCode;		//收藏的股票代码
	private ArrayList<String> collectStrategy;		//收藏的股票策略

	public UserPO(){}

    /**
     *
     * @param accountID 账号
     * @param userName 用户昵称
     * @param phoneNumber 电话号码
     * @param collectStockCode 收藏的股票代码
     * @param collectStrategy 收藏的股票策略
     */
	public UserPO(String accountID , String userName , String phoneNumber ,
                  ArrayList<String> collectStockCode , ArrayList<String> collectStrategy){
        this.accountID = accountID;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.collectStockCode = collectStockCode;
        this.collectStrategy = collectStrategy;
    }

	public String getAccountID() {
		return accountID;
	}
	
	public void setAccountID(String accountID) {
		this.accountID = accountID;
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
	
	public ArrayList<String> getCollectStcokCode() {
		return collectStockCode;
	}
	
	public void setCollectStcokCode(ArrayList<String> collectStcokCode) {
		this.collectStockCode = collectStcokCode;
	}
	
	public ArrayList<String> getCollectStrategy() {
		return collectStrategy;
	}
	
	public void setCollectStrategy(ArrayList<String> collectStrategy) {
		this.collectStrategy = collectStrategy;
	}
	
}
