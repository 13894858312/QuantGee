package po;

import bean.HoldingStock;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 没用
 * Created by wangxue on 2017/5/14.
 */
public class HoldingStocksPO {

    private String userID;
    private Map<String , Integer> stockAndNum;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Map<String, Integer> getStockAndNum() {
        return stockAndNum;
    }

    public void setStockAndNum(Map<String, Integer> stockAndNum) {
        this.stockAndNum = stockAndNum;
    }

    public double getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(double remainMoney) {
        this.remainMoney = remainMoney;
    }

    private double remainMoney;

    public HoldingStocksPO(){}

    public HoldingStocksPO(String userID , Map<String,Integer> stockAndNum , double remainMoney){
        this.userID = userID;
        this.stockAndNum = stockAndNum;
        this.remainMoney = remainMoney;
    }

    public HoldingStocksPO(String userID, Iterator<HoldingStock> holdingStockIterator , double userMoney){
        this.userID = userID;
        this.remainMoney = userMoney;
        stockAndNum = new HashMap<String, Integer>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        while (holdingStockIterator.hasNext()){
            HoldingStock holdingStock = holdingStockIterator.next();
            map.put(holdingStock.getCode(),holdingStock.getHoldNum());
        }
    }
}
