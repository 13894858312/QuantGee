package po;

import bean.HoldingStock;
import bean.UserMoney;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxue on 2017/5/14.
 */
public class HoldingStocksPO {

    private String userID;
    private Map<String , Integer> stockAndNum;
    private double remainMoney;

    public HoldingStocksPO(){}

    public HoldingStocksPO(String userID , Map<String,Integer> stockAndNum , int remainMoney){
        this.userID = userID;
        this.stockAndNum = stockAndNum;
        this.remainMoney = remainMoney;
    }

    public HoldingStocksPO(ArrayList<HoldingStock> holdingStocks , UserMoney userMoney){
        this.userID = userMoney.getUserId();
        //this.remainMoney = userMoney.getRemainMoney();
        stockAndNum = new HashMap<String, Integer>();
        if(holdingStocks!=null && holdingStocks.size()>0){
             for(HoldingStock holdingStock : holdingStocks) {
                 stockAndNum.put(holdingStock.getStockId(), holdingStock.getHoldNum());
             }
        }
    }
}
