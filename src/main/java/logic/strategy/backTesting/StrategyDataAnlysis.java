package logic.strategy.backTesting;

import logic.tools.MathHelper;
import vo.stock.LineVO;
import vo.strategy.CumulativeYieldResultVO;
import vo.strategy.YieldHistogramLineVO;
import vo.strategy.YieldHistogramResultVO;

import java.util.ArrayList;

/**
 * 策略回测完成一些统计量的计算
 * Created by Mark.W on 2017/4/12.
 */
public class StrategyDataAnlysis {

    private static final double RF = 0.04;
    private static final int interval = 1; //直方图分组的间隔为%几
    private static final double YEAR_TRADE_DAYS = 250.0;

    /**
     * 计算有关频率分布直方图的数据
     * @param yieldPerPeriod 周期收益率数据
     * @return YieldHistogramResultVO
     */
    public YieldHistogramResultVO analyseYieldHistogram(ArrayList<Double> yieldPerPeriod) {
        int positiveEarningNum=0, negativeEarningNum=0;
        double maxYield = yieldPerPeriod.get(0), minYield = 0;

        for(int i=0; i<yieldPerPeriod.size(); ++i) {
            if(yieldPerPeriod.get(i) >= 0) {
                positiveEarningNum ++;
                maxYield = Math.max(yieldPerPeriod.get(i), maxYield);
            } else if(yieldPerPeriod.get(i) < 0) {
                negativeEarningNum ++;
                minYield = Math.min(yieldPerPeriod.get(i), minYield);
            }
        }

        maxYield = Math.max(maxYield, -minYield);
        ArrayList<YieldHistogramLineVO> data = calculatePeriodYieldNum(maxYield, yieldPerPeriod);

        double winRate = (double)positiveEarningNum /(double)(positiveEarningNum+negativeEarningNum);
        YieldHistogramResultVO result = new YieldHistogramResultVO(positiveEarningNum, negativeEarningNum, winRate,data);

        return result;
    }

    /**
     * 计算累计收益率图的有关数据
     * @param income 收益+本金
     * @param init_fund 本金
     * @param tradeDays 投资天数
     * @param strategyYield 策略收益率数据
     * @param baseYield 基准收益率数据
     * @return CumulativeYieldResultVO
     */
    public CumulativeYieldResultVO analyseCumulativeYieldGraph(double income, double init_fund, int tradeDays, ArrayList<LineVO> strategyYield, ArrayList<LineVO> baseYield) {
        double annualRevenue = this.calculateAnnualRevenue(income, init_fund, tradeDays);       //策略年化收益率
        double baseAnnualRevenue = this.calculateBaseAnnualRevenue(baseYield, tradeDays);  //基准年化收益率
        double beta = this.calculateBeta(strategyYield, baseYield);
        double alpha = this.calculateAlpha(annualRevenue, baseAnnualRevenue, beta);
        double sharpeRatio = this.calculateSharpRatio(annualRevenue, strategyYield);  //夏普比率
        double maxDrawdown = this.calculateMaxDrawdown(strategyYield);  //最大回撤

        CumulativeYieldResultVO result = new CumulativeYieldResultVO(annualRevenue,baseAnnualRevenue,
                alpha, beta,sharpeRatio, maxDrawdown,strategyYield, baseYield);

        return result;
    }

    /**
     * 计算超额收益率
     * @param income 本金+利益
     * @param initFund 本金
     * @param baseYield 基准收益率
     * @return 超额收益率=策略收益率-基准收益率
     */
    public double analyseAbnormalReturn(double income, double initFund, double baseYield) {
        double result = (income-initFund)/initFund - baseYield;
        return result;
    }

    /**
     * 计算策略胜率
     * @param yields 收益率
     * @return 策略胜率
     */
    public double analyseWinRate(ArrayList<Double> yields) {
        int num = 0;
        for(int i = 0; i< yields.size(); ++i) {
            if(yields.get(i) > 0) {
                num ++;
            }
        }

System.out.println("analyseWinRate: " + num);
System.out.println("analyseWinRate: " + yields.size());

        double result = (double)num / (double) yields.size();
        return result;
    }

    /**
     * 计算周期收益率
     * @param maxYield 最大的周期收益
      * @param yieldPerPeriod 周期收益率
     * @return ArrayList<YieldHistogramLineVO>
     */
    private ArrayList<YieldHistogramLineVO> calculatePeriodYieldNum(double maxYield, ArrayList<Double> yieldPerPeriod) {
        int n = (int)(maxYield * 100) / interval + 1;

        int[] positiveYields = new int[n];          //正收益数量
        for (int i=0; i<positiveYields.length; ++i) {
            positiveYields[i] = 0;
        }

        int[] negativeYields = new int[n];          //负收益数量
        for (int i=0; i<negativeYields.length; ++i) {
            negativeYields[i] = 0;
        }

        for(int i=0; i<yieldPerPeriod.size(); ++i) {
            if(yieldPerPeriod.get(i) >= 0) {
                for(int j=0; j<positiveYields.length; ++j) {
                    double d1 = (double)j/(double)100 * interval;
                    double d2 = (double)(j+1)/(double)100 * interval;
                    if(yieldPerPeriod.get(i) >= d1 && yieldPerPeriod.get(i) < d2) {
                        positiveYields[j] ++;
                        break;
                    }
                }
            } else {
                double temp = -yieldPerPeriod.get(i);
                for(int j=0; j<negativeYields.length; ++j) {
                    double d1 = (double)j/(double)100 * interval;
                    double d2 = (double)(j+1)/(double)100 * interval;
                    if(temp >= d1 && temp < d2) {
                        negativeYields[j] ++;
                        break;
                    }
                }
            }
        }

        ArrayList<YieldHistogramLineVO> result = new ArrayList<>();

        for(int i = 0;i<positiveYields.length; ++i) {
            double startRate = (double)i/(double)100 * interval;
            double endRate = (double)(i+1)/(double)100 * interval;
            result.add(new YieldHistogramLineVO(startRate, endRate, positiveYields[i], negativeYields[i]));
        }

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
//        double annualRevenue = (((income-initFund)/initFund) / tradeDays) * 365;
        double annualRevenue = Math.pow((1+(income-initFund)/initFund), YEAR_TRADE_DAYS/tradeDays)-1;
        return annualRevenue;
    }


    /**
     * 计算alpha
     * @param annualRevenue 年化收益率
     * @param baseAnnualRevenue 基准收益率
     * @param beta beta
     * @return alpha
     */
    private double calculateAlpha(double annualRevenue, double baseAnnualRevenue, double beta) {
        double alpha = annualRevenue - (RF + beta * (baseAnnualRevenue - RF));
        return MathHelper.formatData(alpha,3);
    }

    /**
     * 计算夏普比率=[E(Rp)-Rf]/σp
     * @param annualRevenue 策略年化收益率
     * @param strategyYield 投资区间的策略收益率
     * @return 夏普比率
     */
    private double calculateSharpRatio(double annualRevenue, ArrayList<LineVO> strategyYield) {
        double[] strategy = new double[strategyYield.size()];
        for(int i=0; i<strategyYield.size(); ++i) {
            strategy[i] = strategyYield.get(i).getValue();
        }

        double sharpeRatio = (annualRevenue - RF)/Math.sqrt(250*MathHelper.variance(strategy));
        return MathHelper.formatData(sharpeRatio,3);
    }

    /**
     * 计算beta
     * @param strategyYield 投资区间的策略收益率
     * @param baseYield 投资区间的基准策略收益率
     * @return beta
     */
    private double calculateBeta(ArrayList<LineVO> strategyYield, ArrayList<LineVO> baseYield) {
        double[] strategy = new double[strategyYield.size()];
        for(int i=0; i<strategyYield.size(); ++i) {
            strategy[i] = strategyYield.get(i).getValue();
        }
        double[] base = new double[baseYield.size()];
        for(int i=0; i<baseYield.size(); ++i) {
            base[i] = baseYield.get(i).getValue();
        }

        double beta = MathHelper.covariance(strategy, base)/ MathHelper.variance(base);
        return MathHelper.formatData(beta,3);
    }


    /**
     * 计算基准年化收益率
     * @param baseYield 投资区间的基准策略收益率
     * @return 基准年化收益率
     */
    private double calculateBaseAnnualRevenue(ArrayList<LineVO> baseYield, int tradeDays) {
        double baseAnnualRevenue = 0;
        for(int i=1; i<baseYield.size(); ++i) {
            baseAnnualRevenue += baseYield.get(i).getValue();
        }

        baseAnnualRevenue /= baseYield.size();
        baseAnnualRevenue = Math.pow((1+baseAnnualRevenue), YEAR_TRADE_DAYS/tradeDays)-1;

        return baseAnnualRevenue;
    }

    /**
     * 计算最大回撤
     * @param strategyYield 投资区间的策略收益率
     * @return 最大回撤
     */
    private double calculateMaxDrawdown(ArrayList<LineVO> strategyYield) {
        double maxDrawdown = 0;
        double high = strategyYield.get(0).getValue(), low = high;
        int highIndex = 0, lowIndex = 0;

        for(int i=1; i<strategyYield.size(); ++i) {
            //折线在上升
            if(strategyYield.get(i).getValue() > strategyYield.get(i-1).getValue()) {
                high = strategyYield.get(i).getValue();
                highIndex = i;
            }

            //折线在上升折线在下降
            if(strategyYield.get(i).getValue() < strategyYield.get(i-1).getValue()) {
                low = strategyYield.get(i).getValue();
                lowIndex = i;
            }

            if(highIndex < lowIndex && (high-low) > maxDrawdown) {
                maxDrawdown = high-low;
            }
        }

        return maxDrawdown;
    }
}
