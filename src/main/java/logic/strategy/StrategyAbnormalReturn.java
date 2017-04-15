package logic.strategy;

import logic.tools.MathHelper;
import vo.AbnormalReturnGraphDataVO;
import vo.AbnormalReturnGraphVO;
import vo.BlockType;

import java.util.ArrayList;

/**
 * 动量策略超额收益
 * Created by Mark.W on 2017/4/4.
 */
public class StrategyAbnormalReturn {
    private static final int START_PERIOD = 2;//暂时固定为2-80
    private static final int END_PERIOD = 80;
    private static final int INTERVAL = 2;

    private StockPool stockPool;

    private BlockType blockType;
    private Strategy strategy;
    private int period;
    private int holdingNum;
    private boolean isHoldingPeriod;

    private ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS;  //超额收益率和策略胜率图数据信息
    private AbnormalReturnGraphVO abnormalReturnGraphVO;

    /**
     * @param stockPool 股票池
     * @param period 期间（天数）
     * @param isHoldingPeriod 给定日期是否为持有期
     */
    public StrategyAbnormalReturn(StockPool stockPool, int period, boolean isHoldingPeriod, int holdingNum, Strategy strategy, BlockType blockType) {
        this.stockPool = stockPool;
        this.period = period;
        this.isHoldingPeriod = isHoldingPeriod;
        this.blockType = blockType;
        this.strategy = strategy;
        this.holdingNum = holdingNum;

        this.abnormalReturnGraphDataVOS = new ArrayList<>();
    }

    public void start() {
        StrategyBackTesting strategyBackTesting;

        for(int i=START_PERIOD; i<=END_PERIOD; i+=INTERVAL) {
            if(isHoldingPeriod) {
                strategyBackTesting = new StrategyBackTesting(stockPool, period, i, holdingNum,strategy, blockType);
            } else {
                strategyBackTesting = new StrategyBackTesting(stockPool, i, period, holdingNum,strategy, blockType);
            }

            strategyBackTesting.start();
            double abnormalReturn = strategyBackTesting.getAbnormalReturn();
            double winRate = strategyBackTesting.getWinRate();

            if(isHoldingPeriod) {
                this.abnormalReturnGraphDataVOS.add(new AbnormalReturnGraphDataVO(period, i, abnormalReturn, winRate));
            } else {
                this.abnormalReturnGraphDataVOS.add(new AbnormalReturnGraphDataVO(i, period, abnormalReturn, winRate));
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

        double bestAbnormalReturn = 0;  //最优的超额收益率
        double bestStategyWinRate = 0;   //最优的策略胜率

        //计算以上最优的数据
        for(int i=0; i<this.abnormalReturnGraphDataVOS.size(); ++i) {
            if(this.abnormalReturnGraphDataVOS.get(i).abnormalReturn > bestAbnormalReturn) {
                bestAbnormalReturn = this.abnormalReturnGraphDataVOS.get(i).abnormalReturn;
                bestHoldingPeriod = this.abnormalReturnGraphDataVOS.get(i).holdingPeriod;
                bestReturnPeriod = this.abnormalReturnGraphDataVOS.get(i).returnPeriod;
            }

            if(this.abnormalReturnGraphDataVOS.get(i).stategyWinRate > bestStategyWinRate) {
                bestStategyWinRate = this.abnormalReturnGraphDataVOS.get(i).stategyWinRate;
            }
        }

        this.abnormalReturnGraphVO = new AbnormalReturnGraphVO(isHoldingPeriod, bestHoldingPeriod, bestReturnPeriod,
                MathHelper.formatData(bestAbnormalReturn,4),  MathHelper.formatData(bestStategyWinRate,4),
                this.abnormalReturnGraphDataVOS);
    }

    public AbnormalReturnGraphVO getAbnormalReturnGraphVO() {
        return abnormalReturnGraphVO;
    }
}
