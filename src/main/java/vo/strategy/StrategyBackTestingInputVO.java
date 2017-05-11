package vo.strategy;

import temp.vo.BlockType;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/11.
 * 股票回测输入信息的vo
 */
public class StrategyBackTestingInputVO {
    public String startDate;
    public String endDate; //回测区间

    public StrategyInputType strategyInputType;
    public BlockType blockType;
    public ArrayList<String> stockNames;



    public int holdingPeriod; //调仓周期 (持有期）
    public int returnPeriod; //基准收益率计算周期 (形成期)
    //若是均值回归策略，则是N日移动均线
    public int holdingStockNum; //每次调仓持有的股票数量

    public double ratio; //持有比例
    public boolean notST;   //排除st
}
