package logic.strategy;

import vo.BaseCumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphVO;

import java.util.ArrayList;
import java.util.Date;

import logic.tools.DateHelper;
import po.StockPO;

/**
 * 均值回归策略累计收益率图
 * Created by Mark.W on 2017/4/4.
 */
public class MeanReversionCumlativeYield{
    private StockPool stockPool;

    private int holdingPeriod;  //持有期
    private int returnPeriod;    //形成期
    private int holdingStockNum;  //每个持有期持有的股票数量

    private ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;  //每天的收益率
    private ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS; //基准收益率

    private CumulativeYieldGraphVO cumulativeYieldGraphVO;

    public MeanReversionCumlativeYield(StockPool stockPool, int holdingPeriod, int returnPeriod, int holdingStockNum) {
        this.stockPool = stockPool;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
    }

    public void start(){
    	this.initHoldingStockOnfirstRun();

        Date temp = stockPool.getStartDate();
        int index = 0;     //记录是否达到一个holdingPeriod的index

        while(!DateHelper.getInstance().dateTransToString(temp).equals(DateHelper.getInstance().dateTransToString(stockPool.getEndDate()))) {
            if(index == holdingPeriod) { //若达到holdingPeriod index置0 同时进行rebalance
                index = 0;
                this.rebalance(temp);

            } else {
                index ++;
            }

            this.calculateHoldingStockYield(temp); //计算收益
            temp = DateHelper.getInstance().nextTradeDay(temp);
        }

        this.calculateData();
    }


	private void calculateData() {
		
	}

	public void initHoldingStockOnfirstRun() {
		
		ArrayList<StockYield> stockYields = new ArrayList<>();
		
		for(int i=0; i<stockPool.getStockInfos().size(); ++i) {
			StockPO before = stockPool.getStockInfos().get(i).getBeforeStockPO();
			StockPO yesterday = stockPool.getStockInfos().get(i).getStockByDate(DateHelper.getInstance().formerTradeDay(stockPool.getStartDate()));
			
			if(yesterday == null || before == null) {
				continue;
			}
			
			//计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
			double yield = (yesterday.getADJ()-before.getADJ())/before.getADJ();
			
			stockYields.add(new StockYield(yesterday.getStockCode(), yield));
		}
		
		this.initTopNStocks(stockYields);		
		
	}

	public void initTopNStocks(ArrayList<StockYield> stockYields) {
		// TODO Auto-generated method stub
		
	}

	public void rebalance(Date date) {
		// TODO Auto-generated method stub
		
	}

	public void calculateHoldingStockYield(Date date) {
		// TODO Auto-generated method stub
		
	}
	
	public CumulativeYieldGraphVO getCumulativeYieldGraphVO() {
		return cumulativeYieldGraphVO;
	}
}
