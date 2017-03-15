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
    public AdvCandleStickChart getKLineChart(ArrayList<KLineVO> kLineVOArrayList, int width, int height) throws Exception{
        return new AdvCandleStickChart(kLineVOArrayList, width, height);
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
    public Range_Compare getRangeCompareChart(ArrayList<StockVO> stockVOArrayList){
        return new Range_Compare(stockVOArrayList);
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

}
