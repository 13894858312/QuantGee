package po;

/**
 * Created by PC on 2017/5/5.
 */
public class TradePO {
	
	private String time;	//操作时间
	private String stockCode;	//操作的股票代码
	private String userID;		//操作用户
	private Integer action;		//0表示买。1表示卖
	private Integer numOfStock;		//买卖数量
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getStockCode() {
		return stockCode;
	}
	
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public int getAction() {
		return action;
	}
	
	public void setAction(int action) {
		this.action = action;
	}
	
	public int getNumOfStock() {
		return numOfStock;
	}
	
	public void setNumOfStock(int numOfStock) {
		this.numOfStock = numOfStock;
	}
	
}
