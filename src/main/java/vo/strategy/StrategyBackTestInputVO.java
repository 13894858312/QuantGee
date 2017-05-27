package vo.strategy;


import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 策略计算输入的信息类
 */
public class StrategyBackTestInputVO {
    private int strategyInputType;           //0指定板块 1指定股票
    private int stratrgyType;                //0动量策略 1均值回归
    private String blockType;
    private ArrayList<String> stockNames;

    private String startDate;
    private String endDate; //回测区间

    private int holdingPeriod; //调仓周期 (持有期）
    private int returnPeriod; //基准收益率计算周期 (形成期)
                                //若是均值回归策略，则是N日移动均线
    private int holdingStockNum; //每次调仓持有的股票数量

    private boolean notST;   //排除st

    private double ratio;

    private boolean isHoldingPeriod;     //period参数是否是持有期，true为持有期，false为形成期


    public int getStrategyInputType() {
        return strategyInputType;
    }

    public void setStrategyInputType(int strategyInputType) {
        this.strategyInputType = strategyInputType;
    }

    public int getStratrgyType() {
        return stratrgyType;
    }

    public void setStratrgyType(int stratrgyType) {
        this.stratrgyType = stratrgyType;
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

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public boolean isHoldingPeriod() {
        return isHoldingPeriod;
    }

    public void setHoldingPeriod(boolean holdingPeriod) {
        isHoldingPeriod = holdingPeriod;
    }

    /**
     * 判断StrategyInputVO是否相同 用来确定是否要重新加载股票池
     * @param strategyBackTestInputVO StrategyBackTestInputVO
     * @return boolean
     */
    public boolean equals(StrategyBackTestInputVO strategyBackTestInputVO) {

        boolean temp1 = strategyBackTestInputVO.startDate.equals(startDate)
                && strategyBackTestInputVO.endDate.equals(endDate)
                && (strategyBackTestInputVO.strategyInputType == this.strategyInputType)
                && (strategyBackTestInputVO.blockType == this.blockType);

        boolean temp2 = stockNamesEqual(strategyBackTestInputVO.stockNames);


        return (temp1 && temp2);
    }

    private boolean stockNamesEqual(ArrayList<String> s) {
        if(this.stockNames == null || this.stockNames.size() == 0) {
            if(s == null || s.size() == 0) {
                return true;
            }
        }

        if(s.size() != this.stockNames.size()) {
            return false;
        }

        boolean temp = true;
        for(int i=0; i<this.stockNames.size(); ++i) {
            if(!stockNames.get(i).equals(s.get(i))) {
                temp = false;
                break;
            }
        }

        return temp;
    }

}
