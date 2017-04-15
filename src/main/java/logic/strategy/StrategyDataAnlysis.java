package logic.strategy;

import logic.tools.MathHelper;
import vo.CumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphVO;
import vo.YieldHistogramGraphVO;

import java.util.ArrayList;

/**
 * 策略回测完成一些统计量的计算
 * Created by Mark.W on 2017/4/12.
 */
public class StrategyDataAnlysis {

    private static final double RF = 0.0175;

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
     * @param strategyYield 策略收益率数据
     * @param baseYield 基准收益率数据
     * @return CumulativeYieldGraphVO
     */
    public CumulativeYieldGraphVO analyseCumulativeYieldGraph(double income, double init_fund, int tradeDays,
                                                              ArrayList<CumulativeYieldGraphDataVO> strategyYield,
                                                              ArrayList<CumulativeYieldGraphDataVO> baseYield) {
        double annualRevenue = this.calculateAnnualRevenue(income, init_fund, tradeDays);       //策略年化收益率
        double baseAnnualRevenue = this.calculateBaseAnnualRevenue(baseYield, tradeDays);  //基准年化收益率
        double beta = this.calculateBeta(strategyYield, baseYield);
        double alpha = this.calculateAlpha(annualRevenue, baseAnnualRevenue, beta);
        double sharpeRatio = this.calculateSharpRatio(annualRevenue, strategyYield);  //夏普比率
        double maxDrawdown = this.calculateMaxDrawdown(strategyYield);  //最大回撤

        CumulativeYieldGraphVO cumulativeYieldGraphVO = new CumulativeYieldGraphVO(annualRevenue,baseAnnualRevenue,
                alpha, beta,sharpeRatio, maxDrawdown,strategyYield, baseYield);

        return cumulativeYieldGraphVO;
    }

    /**
     * 计算超额收益率
     * @param income 本金+利益
     * @param initFund 本金
     * @param baseYield 基准收益率
     * @return 超额收益率=策略收益率-基准收益率
     */
    public double analyseAbnormalReturn(double income, double initFund,
                                      ArrayList<CumulativeYieldGraphDataVO> baseYield) {
        double base = 0;
        for(int i=0; i<baseYield.size(); ++i) {
            base += baseYield.get(i).ratio;
        }

        base /= baseYield.size();

        double result = (income-initFund)/initFund - base;
        return MathHelper.formatData(result,4);
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
        return MathHelper.formatData(annualRevenue,4);
    }


    /**
     * 计算alpha
     * @param annualRevenue 年化收益率
     * @param baseAnnualRevenue 基准收益率
     * @param beta beta
     * @return
     */
    private double calculateAlpha(double annualRevenue, double baseAnnualRevenue, double beta) {
        double alpha = (annualRevenue - RF) - beta * (baseAnnualRevenue - RF);
        return MathHelper.formatData(alpha,4);
    }

    /**
     * 计算夏普比率=[E(Rp)-Rf]/σp
     * @param annualRevenue 策略年化收益率
     * @param strategyYield 投资区间的策略收益率
     * @return 夏普比率
     */
    private double calculateSharpRatio(double annualRevenue, ArrayList<CumulativeYieldGraphDataVO> strategyYield) {
        double[] strategy = new double[strategyYield.size()];
        for(int i=0; i<strategyYield.size(); ++i) {
            strategy[i] = strategyYield.get(i).ratio;
        }

        double sharpeRatio = (annualRevenue - RF)/Math.sqrt(MathHelper.variance(strategy));
        return MathHelper.formatData(sharpeRatio,4);
    }

    /**
     * 计算beta
     * @param strategyYield 投资区间的策略收益率
     * @param baseYield 投资区间的基准策略收益率
     * @return beta
     */
    private double calculateBeta(ArrayList<CumulativeYieldGraphDataVO> strategyYield,
                                ArrayList<CumulativeYieldGraphDataVO> baseYield) {
        double[] strategy = new double[strategyYield.size()];
        for(int i=0; i<strategyYield.size(); ++i) {
            strategy[i] = strategyYield.get(i).ratio;
        }

        double[] base = new double[baseYield.size()];
        for(int i=0; i<baseYield.size(); ++i) {
            base[i] = baseYield.get(i).ratio;
        }

        double beta = MathHelper.covariance(strategy, base)/MathHelper.variance(base);

        return beta;
    }


    /**
     * 计算基准年化收益率
     * @param baseYield 投资区间的基准策略收益率
     * @return 基准年化收益率
     */
    private double calculateBaseAnnualRevenue(ArrayList<CumulativeYieldGraphDataVO> baseYield,
                                              int tradeDays) {
        double baseAnnualRevenue = 0;
        for(int i=1; i<baseYield.size(); ++i) {
            baseAnnualRevenue += baseYield.get(i).ratio;
        }

        baseAnnualRevenue /= baseYield.size();

        baseAnnualRevenue = (baseAnnualRevenue/tradeDays) * 365;

        return baseAnnualRevenue;
    }

    /**
     * 计算最大回撤
     * @param strategyYield 投资区间的策略收益率
     * @return 最大回撤
     */
    private double calculateMaxDrawdown(ArrayList<CumulativeYieldGraphDataVO> strategyYield) {
        double maxDrawdown = 0;
        double start = strategyYield.get(0).ratio, end = start;

        for(int i=1; i<strategyYield.size(); ++i) {
            //折线在上升
            if(strategyYield.get(i).ratio > strategyYield.get(i-1).ratio) {
                start = strategyYield.get(i).ratio;
            }

            //折线在上升折线在下降
            if(strategyYield.get(i).ratio < strategyYield.get(i-1).ratio) {
                end = strategyYield.get(i).ratio;
            }

            if((start-end) > maxDrawdown) {
                maxDrawdown = start-end;
            }
        }

        return maxDrawdown;
    }

}
