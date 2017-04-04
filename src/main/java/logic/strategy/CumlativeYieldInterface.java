package logic.strategy;

import logic.tools.DateHelper;
import po.StockPO;
import vo.CumulativeYieldGraphDataVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * 计算累计收益率的接口
 * Created by Mark.W on 2017/4/4.
 */
public interface CumlativeYieldInterface {

    /**
     *  执行回测的主程序
     */
    public void start();


    /**
     * 在第一次运行时 确定持有的股票
     */
    public void initHoldingStockOnfirstRun();

    /**
     * 从所有股票的收益率中选取前holdingStockNum作为持有的股票
     * @param stockYields stockYields
     */
    public void initTopNStocks(ArrayList<StockYield> stockYields);


    /**
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * @param date 日期
     */
    public void rebalance(Date date);

    /**
     * 计算持有股票每天的收益，并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    public void calculateHoldingStockYield(Date date);
}
