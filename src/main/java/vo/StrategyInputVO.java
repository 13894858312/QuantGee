package vo;

import logic.tools.DateHelper;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/23.
 * 策略计算输入的信息类
 */
public class StrategyInputVO {
    public StrategyInputType strategyInputType;
    public BlockType blockType;
    public ArrayList<String> stockNames;

    public Date startDate;
    public Date endDate; //回测区间

    public int holdingPeriod; //调仓周期 (持有期）
    public int returnPeriod; //基准收益率计算周期 (形成期)
                                //若是均值回归策略，则是N日移动均线
    public int holdingStockNum; //每次调仓持有的股票数量


    /**
     * 均值回归策略回测所有股票的构造方法
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     * @param holdingStockNum 每次调仓持有的股票数量
     */
    public StrategyInputVO(Date startDate, Date endDate, int holdingPeriod,
                           int returnPeriod, int holdingStockNum) {
        this.startDate = DateHelper.getInstance().getNextFirstTradeDay(startDate);
        this.endDate = endDate;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.strategyInputType = StrategyInputType.ALL;
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
                           int returnPeriod, int holdingStockNum) {
        this.startDate = DateHelper.getInstance().getNextFirstTradeDay(startDate);
        this.endDate = endDate;
        this.blockType = blockType;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.strategyInputType = StrategyInputType.SPECIFIC_BLOCK;
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
                           int returnPeriod, int holdingStockNum) {
        this.startDate = DateHelper.getInstance().getNextFirstTradeDay(startDate);
        this.endDate = endDate;
        this.stockNames = stockNames;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.strategyInputType = StrategyInputType.SPECIFIC_STOCKS;
    }

    /**
     * 动量策略测所有股票的构造方法
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     */
    public StrategyInputVO(Date startDate, Date endDate, int holdingPeriod, int returnPeriod) {
        this(startDate, endDate, holdingPeriod, returnPeriod, 0);
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
                           int holdingPeriod, int returnPeriod) {
        this(startDate,endDate,blockType,holdingPeriod,returnPeriod, 0);
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
                           int holdingPeriod, int returnPeriod) {
        this(startDate, endDate, stockNames, holdingPeriod, returnPeriod,0);
    }
}
