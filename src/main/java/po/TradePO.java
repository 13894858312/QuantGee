package po;

/**
 * Created by PC on 2017/5/5.
 */
public class TradePO {


    private String tradeID;
	private String time;	//操作时间
	private String stockCode;	//操作的股票代码
	private String userID;		//操作用户
	private Integer action;		//0表示买。1表示卖
	private Integer numOfStock;		//买卖数量

	public TradePO(){}

    /**
     * @param tradeID 交易ID
     * @param time 操作时间
     * @param stockCode 股票代码
     * @param userID 用户ID
     * @param action 0表示买。1表示卖
     * @param numOfStock 买卖数量
     */
	public TradePO(String tradeID , String time , String stockCode ,
                   String userID , Integer action , Integer numOfStock){
	    this.tradeID = tradeID;
	    this.time = time;
	    this.stockCode = stockCode;
	    this.userID = userID;
	    this.action = action;
	    this.numOfStock = numOfStock;
    }

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

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public void setNumOfStock(Integer numOfStock) {
        this.numOfStock = numOfStock;
    }

}
