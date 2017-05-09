package po;

import java.util.ArrayList;

public class UserPO {

	private String AccountID;		//账号	
	private String userName;		//用户昵称
	private String phoneNumber;		//电话号码
	private ArrayList<String> collectStcokCode;		//收藏的股票代码
	private ArrayList<String> collectStrategy;		//收藏的股票策略
	private ArrayList<String> friendsID;			//好友列表

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
	
	public ArrayList<String> getCollectStcokCode() {
		return collectStcokCode;
	}
	
	public void setCollectStcokCode(ArrayList<String> collectStcokCode) {
		this.collectStcokCode = collectStcokCode;
	}
	
	public ArrayList<String> getCollectStrategy() {
		return collectStrategy;
	}
	
	public void setCollectStrategy(ArrayList<String> collectStrategy) {
		this.collectStrategy = collectStrategy;
	}
	
	public ArrayList<String> getFriendsID() {
		return friendsID;
	}
	
	public void setFriendsID(ArrayList<String> friendsID) {
		this.friendsID = friendsID;
	}
	
}
