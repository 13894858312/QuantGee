package view.graph;

import view.UI.*;
import vo.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/8.
 */
public class Graph {

    private static Graph graph;

    public static Graph getInstance(){
        if (graph == null){
            graph = new Graph();
        }
        return graph;
    }

    //K线图
    public AdvCandleStickChart getKLineChart(ArrayList<KLineVO> kLineVOArrayList, ArrayList<AverageLineVO> averageLineVOArrayList1, ArrayList<AverageLineVO> averageLineVOArrayList2,
                                             ArrayList<AverageLineVO> averageLineVOArrayList3, ArrayList<AverageLineVO> averageLineVOArrayList4,ArrayList<AverageLineVO> averageLineVOArrayList5,  int width, int height) throws Exception{
        return new AdvCandleStickChart(kLineVOArrayList,averageLineVOArrayList1,averageLineVOArrayList2, averageLineVOArrayList3, averageLineVOArrayList4, averageLineVOArrayList5,  width, height);
    }

    //k线图chart


    //均线图
    public AverageChart getAverageLineChart(ArrayList<AverageLineVO> averageLineVOArrayList,int width, int height){
        return new AverageChart(averageLineVOArrayList, width, height);
    }

    //最高价、最低价、收盘价比较图
    public Price_Compare getPriceCompareChart(ArrayList<StockVO> stockVOArrayList, int width, int height){
        return new Price_Compare(stockVOArrayList, width, height);
    }

    //涨跌幅比较图
    public Range_Compare getRangeCompareChart(StockVO stockVO1, StockVO stockVO2, int width, int height){
        return new Range_Compare(stockVO1, stockVO2, width, height);
    }

    //对数收益率比较图
    public LogYield_Compare getLogYieldCompareChart(ArrayList<StockDailyInfoVO> stockDailyInfoVOArrayList, int width, int height){
        return new LogYield_Compare(stockDailyInfoVOArrayList, width, height);
    }

    //对数收益率方差比较图
    public LogYieldVar_Compare getLogYieldVarCompareChart(StockVO stockVO1, StockVO stockVO2, int width, int height){
        return new LogYieldVar_Compare(stockVO1, stockVO2, width, height);
    }

    //市场温度计比较图
    public MarketThermometer getMarketThermometerChart(MarketInfoVO marketInfoVO){
        return new MarketThermometer(marketInfoVO);
    }

    //累计收益率折线图
    //cumulativeYieldGraphDataVOArrayList1 基准收益率
    //cumulativeYieldGraphDataVOArrayList2 策略收益率
    public AverageChart getCumulativeYieldChart(ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOArrayList1, ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOArrayList2,
                                                int width, int height){
        return new AverageChart(cumulativeYieldGraphDataVOArrayList1, cumulativeYieldGraphDataVOArrayList2, width, height);
    }

    //超额收益率面积图
    public ExcessEarning getExcessEarning(boolean judge, ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOArrayList, int width, int height){
        return new ExcessEarning(judge, abnormalReturnGraphDataVOArrayList, width, height);
    }

    //策略胜率面积图
    public WinningStrategy getWinningStrategy(boolean judge, ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOArrayList, int width, int height){
        return new WinningStrategy(judge, abnormalReturnGraphDataVOArrayList, width, height);
    }

    //收益率分布直方图
    public DistributionYield getDistributionYield(ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOArrayList, int width, int height){
        return new DistributionYield(yieldHistogramGraphDataVOArrayList, width, height);
    }
}
