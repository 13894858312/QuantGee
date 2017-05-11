package temp.vo;

import logic.tools.DateHelper;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/23.
 * 策略计算输入的信息类
 */
public class StrategyInputVO {


    /**
     * 均值回归策略回测所有股票的构造方法
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     * @param holdingStockNum 每次调仓持有的股票数量
     */
    public StrategyInputVO(Date startDate, Date endDate, int holdingPeriod,
                           int returnPeriod, int holdingStockNum, boolean notST) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.strategyInputType = StrategyInputType.ALL;
        this.notST = notST;
    }


    /**
     * 均值回归策略回测指定板块的股票的构造方法
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param blockType 板块名称
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     * @param holdingStockNum 每次调仓持有的股票数量
     */
    public StrategyInputVO(Date startDate, Date endDate, BlockType blockType, int holdingPeriod,
                           int returnPeriod, int holdingStockNum,boolean notST) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.blockType = blockType;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.strategyInputType = StrategyInputType.SPECIFIC_BLOCK;
        this.notST = notST;
    }

    /**
     * 均值回归策略回测指定的股票的构造方法
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param stockNames 股票名称或代码
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     * @param holdingStockNum 每次调仓持有的股票数量
     */
    public StrategyInputVO(Date startDate, Date endDate, ArrayList<String> stockNames, int holdingPeriod,
                           int returnPeriod, int holdingStockNum, boolean notST) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.stockNames = stockNames;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.strategyInputType = StrategyInputType.SPECIFIC_STOCKS;
        this.notST = notST;
    }

    /**
     * 动量策略测所有股票的构造方法
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     */
    public StrategyInputVO(Date startDate, Date endDate, int holdingPeriod, int returnPeriod, double ratio,boolean notST) {
        this(startDate, endDate, holdingPeriod, returnPeriod, 0,notST);
        this.ratio = ratio;
    }


    /**
     * 动量策略回测指定板块的股票的构造方法
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param blockType 板块名称
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     */
    public StrategyInputVO(Date startDate, Date endDate, BlockType blockType,
                           int holdingPeriod, int returnPeriod, double ratio,boolean notST) {
        this(startDate,endDate,blockType,holdingPeriod,returnPeriod, 0,notST);
        this.ratio = ratio;
    }

    /**
     * 动量策略回测指定的股票的构造方法
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param stockNames 股票名称或代码
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     */
    public StrategyInputVO(Date startDate, Date endDate,ArrayList<String> stockNames,
                           int holdingPeriod, int returnPeriod, double ratio,boolean notST) {
        this(startDate, endDate, stockNames, holdingPeriod, returnPeriod,0,notST);
        this.ratio = ratio;
    }

    /**
     * 判断StrategyInputVO是否相同 用来确定是否要重新加载股票池
     * @param strategyInputVO StrategyInputVO
     * @return boolean
     */
    public boolean equals(StrategyInputVO strategyInputVO) {

        String s1 = DateHelper.getInstance().dateTransToString(strategyInputVO.startDate);
        String e1 = DateHelper.getInstance().dateTransToString(strategyInputVO.endDate);

        String s2 = DateHelper.getInstance().dateTransToString(this.startDate);
        String e2 = DateHelper.getInstance().dateTransToString(this.endDate);

        boolean temp1 = s1.equals(s2) && e1.equals(e2)
                && (strategyInputVO.strategyInputType == this.strategyInputType)
                && (strategyInputVO.blockType == this.blockType);

        boolean temp2 = stockNamesEqual(strategyInputVO.stockNames);


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
