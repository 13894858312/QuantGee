package po;

import bean.Trade;
import bean.TradeUser;

import java.util.ArrayList;

/**
 * 没用
 * Created by wangxue on 2017/5/12.
 */
public class TradeUserPO {

    private String userID;
    private String stockCode;
    private Integer currentHoldingNum;
    private Double currentYield;
    private ArrayList<Trade> trades = new ArrayList<>();

    public TradeUserPO() {}

    /**
     * @param userID 用户ID
     * @param stockCode 股票代码
     * @param currentHoldingNum 当前持有的股数
     * @param currentYield 当前收益率
     * @param trades 对于该股票所有的交易记录
     */
    public TradeUserPO(String userID, String stockCode, int currentHoldingNum, String buyTime,
                       double currentYield, ArrayList<Trade> trades) {
        this.userID = userID;
        this.stockCode = stockCode;
        this.currentHoldingNum = currentHoldingNum;
        this.currentYield = currentYield;
        this.trades = trades;
    }

    public TradeUserPO(TradeUser tradeUser, ArrayList<Trade> trades){
        this.userID = tradeUser.getUserId();
        this.stockCode = tradeUser.getStockId();
        this.currentHoldingNum = tradeUser.getCurrentHoldingNum();
        this.currentYield = tradeUser.getCurrentYield();
        this.trades = trades;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public int getCurrentHoldingNum() {
        return currentHoldingNum;
    }

    public void setCurrentHoldingNum(int currentHoldingNum) {
        this.currentHoldingNum = currentHoldingNum;
    }

    public double getCurrentYield() {
        return currentYield;
    }

    public void setCurrentYield(double currentYield) {
        this.currentYield = currentYield;
    }

    public ArrayList<Trade> getTradeRecordVOS() {
        return trades;
    }

    public void setTradeRecordVOS(ArrayList<Trade> tradeRecordVOS) {
        this.trades = tradeRecordVOS;
    }

}
