package vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/23.
 */
public class StrategyInputVO {
    public Date startDate;
    public Date endDate;
    public boolean isAllStock = false;
    public String blockName;
    public ArrayList<String> stockNames;

    public int holdingPeriod; //调仓周期
    public int returnPeriod; //基准收益率计算周期 形成期
    public int holdingStockNum; //每次调仓持有的股票数量
    public double ratio; //每次持股占股票池的比例


    /**
     * 回测所有股票的构造方法
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     * @param holdingStockNum 每次调仓持有的股票数量
     */
    public StrategyInputVO(Date startDate, Date endDate, int holdingPeriod,
                           int returnPeriod, int holdingStockNum, double ratio) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isAllStock = true;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.ratio = ratio;
    }


    /**
     * 回测指定板块股票的构造方法
     * @param blockName 板块名称
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     * @param holdingStockNum 每次调仓持有的股票数量
     */
    public StrategyInputVO(Date startDate, Date endDate, String blockName, int holdingPeriod,
                           int returnPeriod, int holdingStockNum, double ratio) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.blockName = blockName;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.ratio = ratio;
    }

    /**
     * 回测指定板块股票的构造方法
     * @param stockNames 股票名称或代码
     * @param holdingPeriod 调仓周期
     * @param returnPeriod 基准收益率计算周期
     * @param holdingStockNum 每次调仓持有的股票数量
     */
    public StrategyInputVO(Date startDate, Date endDate,ArrayList<String> stockNames, int holdingPeriod,
                           int returnPeriod, int holdingStockNum, double ratio) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.stockNames = stockNames;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
        this.ratio = ratio;
    }
}
