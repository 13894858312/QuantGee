package logic.strategy;

import java.util.ArrayList;
import java.util.Date;

import logic.calculation.GraphCalculation;
import logic.tools.AverageLineType;
import logic.tools.DateHelper;
import po.StockPO;
import vo.AverageLineVO;

/**
 * 均值回归策略
 * Created by Mark.W on 2017/3/29.
 */
public class MeanReversionStrategy implements Strategy {
	
	private ArrayList<ArrayList<AverageLineVO>> allAverageLine;

    @Override
    public ArrayList<StockYield> initHoldingStocks(StockPool stockPool) {
    	
    	ArrayList<StockYield> stockYields = new ArrayList<>();
    	
    	//确定移动均线类型
    	AverageLineType type ;
    	switch (stockPool.getStrategyInputVO().returnPeriod) {
    	case 5:
    		type = AverageLineType.DAYS_5;
    		break;
    		
    	case 10:
    		type = AverageLineType.DAYS_10;
    		break;
    		
    	case 20:
    		type = AverageLineType.DAYS_20;
    		break;
    		
    	default:
    		return null;
    	}
    	
    	//遍历股票池中数据最多的股票
        for(int i=0; i<stockPool.getStockInfos().size(); ++i) {
            StockPO before = stockPool.getStockInfos().get(i).getBeforeStockPO();
            String beforeDate = before.getDate();
            StockPO yesterday = stockPool.getStockInfos().get(i).getYesterdayStock();
            
            if(yesterday == null || before == null) {
            	continue;
            }
            
            GraphCalculation calculation = new GraphCalculation();
            
            //初始化每一只股票的N日移动均线
            ArrayList<AverageLineVO> averageLine = calculation.getAverageLineInfoByCode(DateHelper.getInstance().stringTransToDate(beforeDate)
            		, stockPool.getEndDate(), yesterday.getStockCode(), type);

            //添加到allAverageLine
            allAverageLine.add(averageLine);
            

            //计算偏离度，(均值-前一天的开盘价)/ 均值
            double yield = (yesterday.getADJ()-before.getADJ())/before.getADJ();

            stockYields.add(new StockYield(yesterday.getStockCode(), yield));
        }

        return stockYields;
    }

    @Override
    public ArrayList<StockYield> rebalanceHoldingStocks(StockPool stockPool, Date beforeDate, Date today) {
        return null;
    }
}
