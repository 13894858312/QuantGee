package logic.strategy;

import vo.AbnormalReturnGraphDataVO;
import vo.AbnormalReturnGraphVO;

import java.util.ArrayList;

/**
 * 动量策略超额收益
 * Created by Mark.W on 2017/4/4.
 */
public class MomentumAbnormalReturn {

    private StockPool stockPool;

    private int period;
    private boolean isHoldingPeriod;

    private ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS;  //超额收益率和策略胜率图数据信息
    private AbnormalReturnGraphVO abnormalReturnGraphVO;

    public MomentumAbnormalReturn(StockPool stockPool, int period, boolean isHoldingPeriod) {
        this.stockPool = stockPool;
        this.period = period;
        this.isHoldingPeriod = isHoldingPeriod;

        this.abnormalReturnGraphDataVOS = new ArrayList<>();
    }

    public void start() {
        MomentumBackTesting momentumBackTesting = null;

        //暂时固定为2-80
        for(int i=2; i<=80; i+=2) {
            if(isHoldingPeriod) {
                momentumBackTesting = new MomentumBackTesting(stockPool, period, i);
            } else {
                momentumBackTesting = new MomentumBackTesting(stockPool, i, period);
            }

            momentumBackTesting.start();
            double abnormalReturn = momentumBackTesting.getAbnormalReturn();
            double winRate = momentumBackTesting.getWinRate();

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

        this.abnormalReturnGraphVO = new AbnormalReturnGraphVO(isHoldingPeriod,bestHoldingPeriod, bestReturnPeriod,
                bestAbnormalReturn, bestStategyWinRate, this.abnormalReturnGraphDataVOS);

    }

    public AbnormalReturnGraphVO getAbnormalReturnGraphVO() {
        return abnormalReturnGraphVO;
    }
}
