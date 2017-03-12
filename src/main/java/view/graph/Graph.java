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

    public AdvCandleStickChart getKLineChart(ArrayList<KLineVO> kLineVOArrayList) throws Exception{
        return new AdvCandleStickChart(kLineVOArrayList);
    }

    public AverageChart getAverageLineChart(ArrayList<AverageLineVO> averageLineVOArrayList){
        return new AverageChart(averageLineVOArrayList);
    }

    public Price_Compare getPriceCompareChart(ArrayList<StockVO> stockVOArrayList, ArrayList<StockDailyInfoVO> stockDailyInfoVOArrayList){
        return new Price_Compare(stockVOArrayList, stockDailyInfoVOArrayList);
    }

    public Range_Compare getRangeCompareChart(ArrayList<StockVO> stockVOArrayList, ArrayList<StockDailyInfoVO> stockDailyInfoVOArrayList){
        return new Range_Compare(stockVOArrayList, stockDailyInfoVOArrayList);
    }

    public LogYieldVar_Compare getLogYieldVarCompareChart(StockVO stockVO1, StockVO stockVO2){
        return new LogYieldVar_Compare(stockVO1, stockVO2);
    }

    public MarketThermometer getMarketThermometerChart(MarketInfoVO marketInfoVO){
        return new MarketThermometer(marketInfoVO);
    }

}
