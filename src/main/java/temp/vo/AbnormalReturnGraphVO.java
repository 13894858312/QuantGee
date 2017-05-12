//package temp.vo;
//
//import logic.tools.MathHelper;
//
//import java.util.ArrayList;
//
///**
// * Created by Mark.W on 2017/3/23.
// * 超额收益率和策略胜率图的信息类
// */
//public class AbnormalReturnGraphVO {
//    public boolean isHoldingPeriodFixed;  //holdingPeriod是否是不变量 true表示holdingPeriod不变，returnPeriod变化
//    public int bestHoldingPeriod;  //最佳持有期
//    public int bestReturnPeriod;  //最佳形成期
//
//    public double bestAbnormalReturn;  //最优的超额收益率
//    public double bestStategyWinRate;   //最优的策略胜率
//
//    public ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS;  //超额收益率和策略胜率图数据信息
//
//    /**
//     * @param isHoldingPeriodFixed true表示holdingPeriod不变，returnPeriod变化
//     * @param bestHoldingPeriod 最佳持有期
//     * @param bestReturnPeriod 最佳形成期
//     * @param bestAbnormalReturn 最优的超额收益率
//     * @param bestStategyWinRate 最优的策略胜率
//     * @param abnormalReturnGraphDataVOS 超额收益率和策略胜率图数据信息
//     */
//    public AbnormalReturnGraphVO(boolean isHoldingPeriodFixed,int bestHoldingPeriod, int bestReturnPeriod, double bestAbnormalReturn,
//                                 double bestStategyWinRate, ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS) {
//        this.isHoldingPeriodFixed = isHoldingPeriodFixed;
//        this.bestHoldingPeriod = bestHoldingPeriod;
//        this.bestReturnPeriod = bestReturnPeriod;
//        this.bestAbnormalReturn = MathHelper.formatData(bestAbnormalReturn*100, 2);
//        this.bestStategyWinRate = MathHelper.formatData(bestStategyWinRate*100, 2);
//        this.abnormalReturnGraphDataVOS = abnormalReturnGraphDataVOS;
//    }
//}
