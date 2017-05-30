package vo.strategy;


import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 策略计算输入的信息类
 */
public class StrategyBackTestInputVO {
    /**
     * 0指定板块 1指定股票
     */
    private int stockPoolType;

    /**
     *0动量策略 1均值回归
     */
    private int strategyType;

    private String blockType;
    private ArrayList<String> stockCodes;

    private String startDate;
    private String endDate; //回测区间

    private int holdingPeriod; //调仓周期 (持有期）
    private int returnPeriod; //基准收益率计算周期 (形成期)
                                //若是均值回归策略，则是N日移动均线
    private int holdingStockNum; //每次调仓持有的股票数量

    private double ratio;

    private boolean notST;   //排除st

    private boolean isHoldingPeriodFixed;     //持有期是否为不变量 用于寻找最佳形成期或持有期


    public int getStockPoolType() {
        return stockPoolType;
    }

    public void setStockPoolType(int stockPoolType) {
        this.stockPoolType = stockPoolType;
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

    public ArrayList<String> getStockCodes() {
        return stockCodes;
    }

    public void setStockCodes(ArrayList<String> stockCodes) {
        this.stockCodes = stockCodes;
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

    public int getHoldingPeriod() {
        return holdingPeriod;
    }

    public void setHoldingPeriodFixed(int holdingPeriodFixed) {
        this.holdingPeriod = holdingPeriodFixed;
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

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public boolean isHoldingPeriodFixed() {
        return isHoldingPeriodFixed;
    }

    public void setHoldingPeriod(boolean holdingPeriod) {
        isHoldingPeriodFixed = holdingPeriod;
    }

    /**
     * 判断StrategyInputVO是否相同 用来确定是否要重新加载股票池
     * @param input StrategyBackTestInputVO
     * @return boolean
     */
    public boolean equals(StrategyBackTestInputVO input) {

        if (input == null) {
            return false;
        }

        boolean temp1 = input.startDate.equals(startDate)
                && input.endDate.equals(endDate)
                && (input.stockPoolType == this.stockPoolType)
                && (input.blockType == this.blockType);

        boolean temp2 = stockNamesEqual(input.stockCodes);


        return (temp1 && temp2);
    }

    private boolean stockNamesEqual(ArrayList<String> s) {
        if(this.stockCodes == null || this.stockCodes.size() == 0) {
            if(s == null || s.size() == 0) {
                return true;
            }
        }

        if(s.size() != this.stockCodes.size()) {
            return false;
        }

        boolean temp = true;
        for(int i = 0; i<this.stockCodes.size(); ++i) {
            if(!stockCodes.get(i).equals(s.get(i))) {
                temp = false;
                break;
            }
        }

        return temp;
    }

}
