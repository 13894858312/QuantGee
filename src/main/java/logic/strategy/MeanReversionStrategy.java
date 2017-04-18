package logic.strategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import data.StockData;
import dataDao.StockDataDao;
import logic.tools.AverageLineType;
import logic.tools.DateHelper;
import logic.tools.MathHelper;
import logic.tools.SwitchAverageLineType;
import po.StockPO;
import vo.AverageLineVO;

/**
 * 均值回归策略
 * Created by Mark.W on 2017/3/29.
 */
public class MeanReversionStrategy implements Strategy {
	
	//保存所有股票的N日移动均线
	private ArrayList<HashMap<String, AverageLineVO>> allAverageLine = new ArrayList<>();

    @Override
    public ArrayList<StockYield> initHoldingStocks(StockPool stockPool,  ArrayList<String> dates) {
    	
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
    	
    	//遍历股票池中股票
        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            StockPO before = stockPool.getStocksList().get(i).getBeforeStockPO();
            String beforeDate = before.getDate();
            StockPO yesterday = stockPool.getStocksList().get(i).getYesterdayStock();
            
            //初始化第i只股票的N日移动均线
            HashMap<String, AverageLineVO> averageLine = getAverageLineInfoByCode(DateHelper.getInstance().stringTransToDate(beforeDate)
            		, stockPool.getEndDate(), yesterday.getStockCode(), type);
            Iterator iterator = averageLine.entrySet().iterator();
            //添加到allAverageLine
            allAverageLine.add(averageLine);

            boolean live = true;                                   //持有期內每天的股票信息必须有 否则不持有该股票
            for(int j=0; j<dates.size(); ++j) {
                StockPO po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if(po == null) {
                    live = false;
                    break;
                }
            }

            if(!live || yesterday == null || before == null) {
            	continue;
            }
            

            //计算偏离度，(均值-当天的开盘价)/ 均值
            //如果当天无数据,跳出循环
            double average = 0;
            if (averageLine.get(DateHelper.getInstance().dateTransToString(stockPool.getStartDate()))!=null) {
            	average = averageLine.get(DateHelper.getInstance().dateTransToString(stockPool.getStartDate())).averageValue;
			}
            double yield = (average-yesterday.getADJ())/average;

            stockYields.add(new StockYield(yesterday.getStockCode(), yield));
        }

        return stockYields;
    }

    @Override
    public ArrayList<StockYield> rebalanceHoldingStocks(StockPool stockPool, String beforeDate, String today,  ArrayList<String> dates) {

    	ArrayList<StockYield> stockYields = new ArrayList<>();

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            StockPO before = stockPool.getStocksList().get(i).getStockByDate(beforeDate);
            StockPO yesterday = stockPool.getStocksList().get(i).getStockByDate(today);

            boolean live = true;                                   //持有期內每天的股票信息必须有 否则不持有该股票
            for(int j=0; j<dates.size(); ++j) {
                StockPO po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if(po == null) {
                    live = false;
                    break;
                }
            }

            if(live && yesterday != null && before != null) {
                //计算偏离度，(均值-当天的开盘价)/ 均值
            	double average = 0;
            	if (allAverageLine.get(i).get(today)!=null) {
            		average = allAverageLine.get(i).get(today).averageValue;
				}
                double yield = (average-yesterday.getADJ())/average;

                stockYields.add(new StockYield(yesterday.getStockCode(), yield));
            }

        }
        
        return stockYields;
    }
    
    
    /**
     * 辅助方法，获取N日移动均线
     * @param startDate
     * @param endDate
     * @param stockCode
     * @param averageLineType
     * @return
     */
    public HashMap<String, AverageLineVO> getAverageLineInfoByCode(Date startDate, Date endDate, String stockCode, AverageLineType averageLineType) {

        assert (stockCode != null && !stockCode.equals("") && startDate != null && endDate != null)
                : "logic.calculation.GraphCalculation.getAverageLineInfoByCode参数异常";
        
        StockDataDao stockDataDao = new StockData();

        //获取均线图的时间间隔
        int dayNums = SwitchAverageLineType.getDayInterval(averageLineType);
        if(dayNums > DateHelper.getInstance().calculateDaysBetween(startDate, endDate)) {
            return null;
        }

        //如果总天数小于均线图的时间间隔出错
        ArrayList<StockPO> stockPOS = stockDataDao.getStockPOsByTimeInterval(DateHelper.getInstance().dateTransToString(startDate),
                DateHelper.getInstance().dateTransToString(endDate), stockCode,false);
        if(dayNums > stockPOS.size()) {
            return null;
        }

       HashMap<String, AverageLineVO> result = new HashMap<>();
       
       for(int i=stockPOS.size()-dayNums; i>=0; i--) {
    	   Date date = DateHelper.getInstance().stringTransToDate(stockPOS.get(i).getDate());
    	   
    	   double all = 0;
    	   for(int j=i+dayNums-1; j>i-1; j--) {
    		   all += stockPOS.get(j).getClosePrice();
    	   }
    	   
    	   double average = MathHelper.formatData(all/dayNums, 2);
    	   
    	   result.put(stockPOS.get(i).getDate(),new AverageLineVO(stockPOS.get(i).getStockCode(), stockPOS.get(i).getStockName(),averageLineType, date, average));
       }
       
       return result;
    }
}
