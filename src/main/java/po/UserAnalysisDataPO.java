package po;

import jnr.ffi.annotations.In;

import java.util.Map;

public class UserAnalysisDataPO {

    private int userNum;								//总的用户数量
	private Map<String, Integer> registerNumByTime;		//按时间获取注册数量

	public UserAnalysisDataPO(){}

	/**
	 *
	 * @param userNum 总用户数量
	 * @param registerNumByTime 每日注册量
	 */
	public UserAnalysisDataPO(int userNum , Map<String , Integer> registerNumByTime){
		this.userNum = userNum;
		this.registerNumByTime = registerNumByTime;
	}

	public int getUserNum(){
		return  userNum;
	}

	public void setUserNum(int userNum){
		this.userNum = userNum;
	}

    public Map<String, Integer> getRegisterNumByTime() {
		return registerNumByTime;
	}

	public void setRegisterNumByTime(Map<String, Integer> registerNumByTime) {
		this.registerNumByTime = registerNumByTime;
	}
	
}
