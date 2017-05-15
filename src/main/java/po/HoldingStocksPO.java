package po;

import bean.HoldingStocks;
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
    private int remainMoney;

    public HoldingStocksPO(){}

    public HoldingStocksPO(String userID , Map<String,Integer> stockAndNum , int remainMoney){
        this.userID = userID;
        this.stockAndNum = stockAndNum;
        this.remainMoney = remainMoney;
    }

    public HoldingStocksPO(ArrayList<HoldingStocks> holdingStockses , UserMoney userMoney){
        this.userID = userMoney.getUserId();
        //this.remainMoney = userMoney.getRemainMoney();
        stockAndNum = new HashMap<String, Integer>();
        if(holdingStockses!=null && holdingStockses.size()>0){
             for(HoldingStocks holdingStocks : holdingStockses) {
                 stockAndNum.put(holdingStocks.getStockCode(), holdingStocks.getHoldNum());
             }
        }
    }
}
