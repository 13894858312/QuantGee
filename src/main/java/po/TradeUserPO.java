package po;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/12.
 */
public class TradeUserPO {

    private String userID;
    private String stockCode;
    private Integer currentHoldingNum;
    private Double currentYield;
    private ArrayList<TradePO> tradePOs = new ArrayList<>();

    public TradeUserPO() {}

    /**
     * @param userID 用户ID
     * @param stockCode 股票代码
     * @param currentHoldingNum 当前持有的股数
     * @param currentYield 当前收益率
     * @param tradePOs 对于该股票所有的交易记录
     */
    public TradeUserPO(String userID, String stockCode, int currentHoldingNum, String buyTime,
                       double currentYield, ArrayList<TradePO> tradePOs) {
        this.userID = userID;
        this.stockCode = stockCode;
        this.currentHoldingNum = currentHoldingNum;
        this.currentYield = currentYield;
        this.tradePOs = tradePOs;
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

    public ArrayList<TradePO> getTradeRecordVOS() {
        return tradePOs;
    }

    public void setTradeRecordVOS(ArrayList<TradePO> tradeRecordVOS) {
        this.tradePOs = tradeRecordVOS;
    }

}
