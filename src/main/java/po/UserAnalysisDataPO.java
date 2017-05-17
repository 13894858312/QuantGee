package po;

import java.util.Map;

public class UserAnalysisDataPO {

    private long userNum;								//总的用户数量
	private Map<String, Integer> registerNumByTime;		//按时间获取注册数量

	public UserAnalysisDataPO(){}

	/**
	 *
	 * @param userNum 总用户数量
	 * @param registerNumByTime 每日注册量
	 */
	public UserAnalysisDataPO(long userNum , Map<String , Integer> registerNumByTime){
		this.userNum = userNum;
		this.registerNumByTime = registerNumByTime;
	}

	public long getUserNum(){
		return  userNum;
	}

	public void setUserNum(long userNum){
		this.userNum = userNum;
	}

    public Map<String, Integer> getRegisterNumByTime() {
		return registerNumByTime;
	}

	public void setRegisterNumByTime(Map<String, Integer> registerNumByTime) {
		this.registerNumByTime = registerNumByTime;
	}
	
}
