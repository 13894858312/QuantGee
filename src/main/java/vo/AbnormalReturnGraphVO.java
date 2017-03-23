package vo;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 超额收益率和策略胜率图的信息类
 */
public class AbnormalReturnGraphVO {
    public int bestHoldingPeriod;  //最佳持有期
    public int bestReturnPeriod;  //最佳形成期

    public double bestAbnormalReturn;  //最优的超额收益率
    public double bestStategyWinRate;   //最优的策略胜率

    public ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS;  //超额收益率和策略胜率图数据信息

    /**
     *
     * @param bestHoldingPeriod 最佳持有期
     * @param bestReturnPeriod 最佳形成期
     * @param bestAbnormalReturn 最优的超额收益率
     * @param bestStategyWinRate 最优的策略胜率
     * @param abnormalReturnGraphDataVOS 超额收益率和策略胜率图数据信息
     */
    public AbnormalReturnGraphVO(int bestHoldingPeriod, int bestReturnPeriod, double bestAbnormalReturn,
                                 double bestStategyWinRate, ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS) {
        this.bestHoldingPeriod = bestHoldingPeriod;
        this.bestReturnPeriod = bestReturnPeriod;
        this.bestAbnormalReturn = bestAbnormalReturn;
        this.bestStategyWinRate = bestStategyWinRate;
        this.abnormalReturnGraphDataVOS = abnormalReturnGraphDataVOS;
    }
}
