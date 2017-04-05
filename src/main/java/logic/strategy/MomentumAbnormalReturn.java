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

    private double period;
    private boolean isHoldingPeriod;

    private ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS;  //超额收益率和策略胜率图数据信息
    private AbnormalReturnGraphVO abnormalReturnGraphVO;

    public MomentumAbnormalReturn(StockPool stockPool, double period, boolean isHoldingPeriod) {
        this.stockPool = stockPool;
        this.period = period;
        this.isHoldingPeriod = isHoldingPeriod;
    }

    public void start() {

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

        this.abnormalReturnGraphVO = new AbnormalReturnGraphVO(bestHoldingPeriod, bestReturnPeriod,
                bestAbnormalReturn, bestStategyWinRate, this.abnormalReturnGraphDataVOS);

    }


    public AbnormalReturnGraphVO getAbnormalReturnGraphVO() {
        return abnormalReturnGraphVO;
    }
}
