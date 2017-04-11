package logic.strategy;

import vo.BaseCumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphVO;

import java.util.ArrayList;
import java.util.Date;

import logic.tools.DateHelper;
import logic.tools.MathHelper;
import po.StockPO;

/**
 * 均值回归策略累计收益率图
 * Created by Mark.W on 2017/4/4.
 */
public class MeanReversionCumlativeYield{
    private StockPool stockPool;

    private int holdingPeriod;  //持有期
    private int returnPeriod;    //n日移动均线
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
	
	 /**
     * 计算累计收益率图的分析结果数据
     */
    private void finish() {

        double annualRevenue = calculateAnnualRevenue();       //策略年化收益率
        double baseAnnualRevenue = calculateBaseAnnualRevenue();  //基准年化收益率\
        double beta = calculateBeta();
        double alpha = calculateAlpha(annualRevenue, baseAnnualRevenue, beta);
        double sharpeRatio = calculateSharpRatio(annualRevenue);  //夏普比率
        double maxDrawdown = calculateMaxDrawdown();  //最大回撤

        this.cumulativeYieldGraphVO = new CumulativeYieldGraphVO(annualRevenue,baseAnnualRevenue,
                alpha, beta,sharpeRatio, maxDrawdown,cumulativeYieldGraphDataVOS, baseCumulativeYieldGraphDataVOS);

    }

    /**
     * 计算策略年化收益率
     * @return 策略年化收益率
     */
    private double calculateAnnualRevenue() {
        double annualRevenue = 0;
        return annualRevenue;
    }


    /**
     * 计算alpha
     * @param annualRevenue 年化收益率
     * @param baseAnnualRevenue 基准收益率
     * @param beta beta
     * @return
     */
    private double calculateAlpha(double annualRevenue, double baseAnnualRevenue, double beta) {
        double rf = 0.0175;
        double alpha = annualRevenue - rf - beta * (baseAnnualRevenue - rf);
        return alpha;
    }

    /**
     * 计算夏普比率
     * @return 夏普比率
     */
    private double calculateSharpRatio(double annualRevenue) {
        double rf = 0.0175;
        double[] strategy = new double[this.cumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<this.cumulativeYieldGraphDataVOS.size(); ++i) {
            strategy[i] = this.cumulativeYieldGraphDataVOS.get(i).ratio;
        }

        double sharpeRatio = (annualRevenue - rf)/Math.sqrt(MathHelper.variance(strategy));

        return sharpeRatio;
    }

    /**
     * 计算beta
     * @return beta
     */
    private double calculateBeta() {
        double[] strategy = new double[this.cumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<this.cumulativeYieldGraphDataVOS.size(); ++i) {
            strategy[i] = this.cumulativeYieldGraphDataVOS.get(i).ratio;
        }

        double[] base = new double[this.baseCumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<this.baseCumulativeYieldGraphDataVOS.size(); ++i) {
            base[i] = this.baseCumulativeYieldGraphDataVOS.get(i).baseRatio;
        }

        double beta = MathHelper.covariance(strategy, base)/MathHelper.variance(base);

        return beta;
    }


    /**
     * 计算基准年化收益率
     * @return 基准年化收益率
     */
    private double calculateBaseAnnualRevenue() {
        double baseAnnualRevenue = 0;
        for(int i=1; i<this.baseCumulativeYieldGraphDataVOS.size(); ++i) {
            baseAnnualRevenue += this.baseCumulativeYieldGraphDataVOS.get(i).baseRatio;
        }
        baseAnnualRevenue /= this.baseCumulativeYieldGraphDataVOS.size();

        return baseAnnualRevenue;
    }

    /**
     * 计算最大回撤
     * @return 最大回撤
     */
    private double calculateMaxDrawdown() {
        double maxDrawdown = 0;

        double start = this.cumulativeYieldGraphDataVOS.get(0).ratio, end = start;

        for(int i=1; i<this.cumulativeYieldGraphDataVOS.size(); ++i) {
            //折线在上升
            if(cumulativeYieldGraphDataVOS.get(i).ratio > cumulativeYieldGraphDataVOS.get(i-1).ratio) {
                start = cumulativeYieldGraphDataVOS.get(i).ratio;
            }

            //折线在上升折线在下降
            if(cumulativeYieldGraphDataVOS.get(i).ratio < cumulativeYieldGraphDataVOS.get(i-1).ratio) {
                end = cumulativeYieldGraphDataVOS.get(i).ratio;
            }

            if((start-end) > maxDrawdown) {
                maxDrawdown = start-end;
            }
        }

        return maxDrawdown;
    }

}
