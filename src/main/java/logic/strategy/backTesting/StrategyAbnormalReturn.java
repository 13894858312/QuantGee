package logic.strategy.backTesting;


import vo.strategy.AbnormalReturnLineVO;
import vo.strategy.AbnormalReturnResultVO;

import java.util.ArrayList;

/**
 * 动量策略超额收益
 * Created by Mark.W on 2017/4/4.
 */
public class StrategyAbnormalReturn {
    private static final int START_PERIOD = 2;//暂时固定为2-80
    private static final int INTERVAL = 2;
    private int END_PERIOD;

    private StockPool stockPool;
    private IStrategy IStrategy;

    private int period;
    private boolean isHoldingPeriod;

    private ArrayList<AbnormalReturnLineVO> abnormalReturnLines;  //超额收益率和策略胜率图数据信息
    private AbnormalReturnResultVO abnormalReturnResult;

    /**
     * @param stockPool 股票池
     * @param period 期间（天数）
     * @param isHoldingPeriod 给定日期是否为持有期
     */
    public StrategyAbnormalReturn(StockPool stockPool, int period, boolean isHoldingPeriod, IStrategy IStrategy) {
        this.stockPool = stockPool;
        this.period = period;
        this.isHoldingPeriod = isHoldingPeriod;
        this.IStrategy = IStrategy;
        this.END_PERIOD = Math.min(stockPool.getTradeDays()/2, 80);           //最高值取交易日除以二

        this.abnormalReturnLines = new ArrayList<>();
    }

    public void start() {
        StrategyBackTesting strategyBackTesting;

        if(isHoldingPeriod) {
            this.abnormalReturnLines.add(new AbnormalReturnLineVO(period, 0, 0, 0));
        } else {
            this.abnormalReturnLines.add(new AbnormalReturnLineVO(0, period, 0, 0));
        }

        for(int i=START_PERIOD; i<=END_PERIOD; i+=INTERVAL) {
            if(isHoldingPeriod) {
                strategyBackTesting = new StrategyBackTesting(stockPool, period, i, IStrategy,true);
            } else {
                strategyBackTesting = new StrategyBackTesting(stockPool, i, period, IStrategy,true);
            }

            strategyBackTesting.start();
            double abnormalReturn = strategyBackTesting.getAbnormalReturn();
            double winRate = strategyBackTesting.getWinRate();

System.out.println("                                          " + i + " abnormalReturn " + abnormalReturn);
System.out.println("                                          " + i + " winRate " + winRate);

            if(isHoldingPeriod) {
                this.abnormalReturnLines.add(new AbnormalReturnLineVO(period, i, abnormalReturn, winRate));
            } else {
                this.abnormalReturnLines.add(new AbnormalReturnLineVO(i, period, abnormalReturn, winRate));
            }
        }

        this.calculateData();
    }

    /**
     *  计算累计超额收益率图的分析结果数据
     */
    private void calculateData() {
        int bestHoldingPeriod = 0;  //最佳持有期
        int bestReturnPeriod = 0;   //最佳形成期

        double bestAbnormalReturn = abnormalReturnLines.get(1).getAbnormalReturn();  //最优的超额收益率
        double bestStategyWinRate = abnormalReturnLines.get(1).getStategyWinRate();   //最优的策略胜率

        //计算以上最优的数据
        for(int i = 2; i<this.abnormalReturnLines.size(); ++i) {
            if(this.abnormalReturnLines.get(i).getAbnormalReturn() > bestAbnormalReturn) {
                bestAbnormalReturn = this.abnormalReturnLines.get(i).getAbnormalReturn();
                bestHoldingPeriod = this.abnormalReturnLines.get(i).getHoldingPeriod();
                bestReturnPeriod = this.abnormalReturnLines.get(i).getReturnPeriod();
            }

            if(this.abnormalReturnLines.get(i).getStategyWinRate() > bestStategyWinRate) {
                bestStategyWinRate = this.abnormalReturnLines.get(i).getStategyWinRate();
            }
        }

        this.abnormalReturnResult = new AbnormalReturnResultVO(isHoldingPeriod, bestHoldingPeriod, bestReturnPeriod,
                bestAbnormalReturn,bestStategyWinRate, this.abnormalReturnLines);
    }

    public AbnormalReturnResultVO getAbnormalReturnResult() {
        return abnormalReturnResult;
    }
}
