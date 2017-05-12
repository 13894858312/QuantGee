package bean;

import po.TradePO;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/12.
 */
public class TradeUser {

    private String userID;
    private String stockCode;
    private Integer currentHoldingNum;
    private Double currentYield;

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

    public Integer getCurrentHoldingNum() {
        return currentHoldingNum;
    }

    public void setCurrentHoldingNum(Integer currentHoldingNum) {
        this.currentHoldingNum = currentHoldingNum;
    }

    public Double getCurrentYield() {
        return currentYield;
    }

    public void setCurrentYield(Double currentYield) {
        this.currentYield = currentYield;
    }

}
