package logic.strategy;

import logic.tools.MathHelper;
import vo.BaseCumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphVO;
import vo.YieldHistogramGraphVO;

import java.util.ArrayList;

/**
 * 策略回测完成一些统计量的计算
 * Created by Mark.W on 2017/4/12.
 */
public class StrategyDataAnlysis {

    /**
     * 计算有关频率分布直方图的数据
     * @param yieldPerPeriod 周期收益率数据
     * @return YieldHistogramGraphVO
     */
    public YieldHistogramGraphVO analyseYieldHistogram(ArrayList<Double> yieldPerPeriod) {
        int positiveEarningNum=0, negativeEarningNum=0;

        for(int i=0; i<yieldPerPeriod.size(); ++i) {
            if(yieldPerPeriod.get(i) > 0) {
                positiveEarningNum ++;
            } else if(yieldPerPeriod.get(i) < 0) {
                negativeEarningNum ++;
            }
        }

        //待填代码 没确定直方图的数据形式

        YieldHistogramGraphVO yieldHistogramGraphVO = null;
        return yieldHistogramGraphVO;
    }

    /**
     * 计算累计收益率图的有关数据
     * @param income 收益+本金
     * @param init_fund 本金
     * @param tradeDays 投资天数
     * @param cumulativeYieldGraphDataVOS 策略收益率数据
     * @param baseCumulativeYieldGraphDataVOS 基准收益率数据
     * @return CumulativeYieldGraphVO
     */
    public CumulativeYieldGraphVO analyseCumulativeYieldGraph(double income, double init_fund, int tradeDays,
                                                              ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS,
                                                              ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS) {
        double annualRevenue = this.calculateAnnualRevenue(income, init_fund, tradeDays);       //策略年化收益率
        double baseAnnualRevenue = this.calculateBaseAnnualRevenue(tradeDays, baseCumulativeYieldGraphDataVOS);  //基准年化收益率\
        double beta = this.calculateBeta(cumulativeYieldGraphDataVOS, baseCumulativeYieldGraphDataVOS);
        double alpha = this.calculateAlpha(annualRevenue, baseAnnualRevenue, beta);
        double sharpeRatio = this.calculateSharpRatio(annualRevenue, cumulativeYieldGraphDataVOS);  //夏普比率
        double maxDrawdown = this.calculateMaxDrawdown(cumulativeYieldGraphDataVOS);  //最大回撤

        CumulativeYieldGraphVO cumulativeYieldGraphVO = new CumulativeYieldGraphVO(annualRevenue,baseAnnualRevenue,
                alpha, beta,sharpeRatio, maxDrawdown,cumulativeYieldGraphDataVOS, baseCumulativeYieldGraphDataVOS);

        return cumulativeYieldGraphVO;
    }

    /**
     * 计算超额收益率
     * @param income 本金+利益
     * @param initFund 本金
     * @param baseCumulativeYieldGraphDataVOS 基准收益率
     * @return 超额收益率
     */
    public double analyseAbnormalReturn(double income, double initFund,
                                      ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS) {
        double base = 0;
        for(int i=0; i<baseCumulativeYieldGraphDataVOS.size(); ++i) {
            base += baseCumulativeYieldGraphDataVOS.get(i).baseRatio;
        }

        base /= baseCumulativeYieldGraphDataVOS.size();

        double result = (income-initFund)/initFund - base;
        return result;
    }

    /**
     * 计算策略年化收益率
     * @param income 本金+收益
     * @param initFund 本金
     * @param tradeDays 投资天数
     * @return 策略年化收益率
     */
    private double calculateAnnualRevenue(double income, double initFund, int tradeDays) {
        double annualRevenue = (((income-initFund)/initFund) / tradeDays) * 365;
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
     * @param annualRevenue 策略年化收益率
     * @param cumulativeYieldGraphDataVOS 投资区间的策略收益率
     * @return 夏普比率
     */
    private double calculateSharpRatio(double annualRevenue, ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS) {
        double rf = 0.0175;
        double[] strategy = new double[cumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<cumulativeYieldGraphDataVOS.size(); ++i) {
            strategy[i] = cumulativeYieldGraphDataVOS.get(i).ratio;
        }

        double sharpeRatio = (annualRevenue - rf)/Math.sqrt(MathHelper.variance(strategy));

        return sharpeRatio;
    }

    /**
     * 计算beta
     * @param cumulativeYieldGraphDataVOS 投资区间的策略收益率
     * @param baseCumulativeYieldGraphDataVOS 投资区间的基准策略收益率
     * @return beta
     */
    private double calculateBeta(ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS,
                                ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS) {
        double[] strategy = new double[cumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<cumulativeYieldGraphDataVOS.size(); ++i) {
            strategy[i] = cumulativeYieldGraphDataVOS.get(i).ratio;
        }

        double[] base = new double[baseCumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<baseCumulativeYieldGraphDataVOS.size(); ++i) {
            base[i] = baseCumulativeYieldGraphDataVOS.get(i).baseRatio;
        }

        double beta = MathHelper.covariance(strategy, base)/MathHelper.variance(base);

        return beta;
    }


    /**
     * 计算基准年化收益率
     * @param baseCumulativeYieldGraphDataVOS 投资区间的基准策略收益率
     * @return 基准年化收益率
     */
    private double calculateBaseAnnualRevenue(int tradeDays,
                                              ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS) {
        double baseAnnualRevenue = 0;
        for(int i=1; i<baseCumulativeYieldGraphDataVOS.size(); ++i) {
            baseAnnualRevenue += baseCumulativeYieldGraphDataVOS.get(i).baseRatio;
        }
        baseAnnualRevenue /= baseCumulativeYieldGraphDataVOS.size();

        baseAnnualRevenue = (baseAnnualRevenue/tradeDays) * 365;

        return baseAnnualRevenue;
    }

    /**
     * 计算最大回撤
     * @param cumulativeYieldGraphDataVOS 投资区间的策略收益率
     * @return 最大回撤
     */
    private double calculateMaxDrawdown(ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS) {
        double maxDrawdown = 0;
        double start = cumulativeYieldGraphDataVOS.get(0).ratio, end = start;

        for(int i=1; i<cumulativeYieldGraphDataVOS.size(); ++i) {
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
