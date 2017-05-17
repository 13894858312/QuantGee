package vo.admin;

import java.util.Map;

/**
 * 管理员获取网站用户注册信息
 */
public class UserAnalysisDataVO {

	private long userNum;								//总的用户数量
	private Map<String, Integer> registerNumByTime;		//按时间获取注册数量

	public UserAnalysisDataVO() {}

	/**
	 * @param userNum 总的用户数量
	 * @param registerNumByTime 按时间获取注册数量
	 */
	public UserAnalysisDataVO(long userNum, Map<String, Integer> registerNumByTime) {
		this.userNum = userNum;
		this.registerNumByTime = registerNumByTime;
	}

	public long getUserNum() {
		return userNum;
	}

	public void setUserNum(long userNum) {
		this.userNum = userNum;
	}

	public Map<String, Integer> getRegisterNumByTime() {
		return registerNumByTime;
	}

	public void setRegisterNumByTime(Map<String, Integer> registerNumByTime) {
		this.registerNumByTime = registerNumByTime;
	}
}
