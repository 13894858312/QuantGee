package vo.trade;


import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/11.
 * 对于每个用户当前所有在模拟交易的信息的vo
 */
public class TradeUserVO {
    private String userID;
    private String stockCode;
    private int currentHoldingNum;
    private double currentYield;

    private ArrayList<TradeRecordVO> tradeRecordVOS = new ArrayList<>();

    public TradeUserVO() {}

    /**
     * @param userID 用户ID
     * @param stockCode 股票代码
     * @param currentHoldingNum 当前持有的股数
     * @param currentYield 当前收益率
     * @param tradeRecordVOS 对于该股票所有的交易记录
     */
    public TradeUserVO(String userID, String stockCode, int currentHoldingNum, String buyTime,
                       double currentYield, ArrayList<TradeRecordVO> tradeRecordVOS) {
        this.userID = userID;
        this.stockCode = stockCode;
        this.currentHoldingNum = currentHoldingNum;
        this.currentYield = currentYield;
        this.tradeRecordVOS = tradeRecordVOS;
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

    public ArrayList<TradeRecordVO> getTradeRecordVOS() {
        return tradeRecordVOS;
    }

    public void setTradeRecordVOS(ArrayList<TradeRecordVO> tradeRecordVOS) {
        this.tradeRecordVOS = tradeRecordVOS;
    }
}
