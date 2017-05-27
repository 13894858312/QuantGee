package vo.strategy;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/26.
 * 策略回测输入信息s
 */
public class StrategyBackTestInputVO {
    private String stockCode;
    private String startDate;
    private String endDate;
    private int strategyType; //策略类型 1:动量策略 2:均值回归

    private int holdingPeriod;   //调仓周期 (持有期）
    private int returnPeriod;    //基准收益率计算周期 (形成期) 若是均值回归策略，则是N日移动均线
    private int holdingStockNum; //每次调仓持有的股票数量

    private String blockType;
    private ArrayList<String> stockNames;

    private boolean notST;   //排除st

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(int strategyType) {
        this.strategyType = strategyType;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public ArrayList<String> getStockNames() {
        return stockNames;
    }

    public void setStockNames(ArrayList<String> stockNames) {
        this.stockNames = stockNames;
    }

    public int getHoldingPeriod() {
        return holdingPeriod;
    }

    public void setHoldingPeriod(int holdingPeriod) {
        this.holdingPeriod = holdingPeriod;
    }

    public int getReturnPeriod() {
        return returnPeriod;
    }

    public void setReturnPeriod(int returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    public int getHoldingStockNum() {
        return holdingStockNum;
    }

    public void setHoldingStockNum(int holdingStockNum) {
        this.holdingStockNum = holdingStockNum;
    }

    public boolean isNotST() {
        return notST;
    }

    public void setNotST(boolean notST) {
        this.notST = notST;
    }
}
