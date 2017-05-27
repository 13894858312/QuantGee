package vo.strategy;

import logic.tools.DateHelper;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/23.
 * 策略计算输入的信息类
 */
public class StrategyBackTestInputVO {
    public int strategyInputType;           //0指定板块 1指定股票
    public int stratrgyType;                //0动量策略 1均值回归
    public String blockType;
    public ArrayList<String> stockNames;

    public String startDate;
    public String endDate; //回测区间

    public int holdingPeriod; //调仓周期 (持有期）
    public int returnPeriod; //基准收益率计算周期 (形成期)
                                //若是均值回归策略，则是N日移动均线
    public int holdingStockNum; //每次调仓持有的股票数量

    public boolean notST;   //排除st

    public double ratio;


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
