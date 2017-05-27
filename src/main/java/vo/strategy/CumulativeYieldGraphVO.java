package vo.strategy;

import logic.tools.MathHelper;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 累计收益率图的信息类
 */
public class CumulativeYieldGraphVO {
    private double annualRevenue;       //年化收益率
    private double baseAnnualRevenue;  //基准年化收益率
    private double alpha;
    private double beta;
    private double sharpeRatio;  //夏普比率
    private double maxDrawdown;  //最大回撤
    private ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;       //策略收益率
    private ArrayList<CumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS; //基准收益率

    /**
     * 收益率图
     * @param annualRevenue 年化收益率
     * @param baseAnnualRevenue 基准年化收益率
     * @param alpha alpha
     * @param beta beta
     * @param sharpeRatio 夏普比率
     * @param maxDrawdown 最大回撤
     * @param cumulativeYieldGraphDataVOS 收益坐标信息
     * @param baseCumulativeYieldGraphDataVOS  基准收益坐标信息
     */
    public CumulativeYieldGraphVO(double annualRevenue, double baseAnnualRevenue, double alpha,
                                  double beta, double sharpeRatio, double maxDrawdown,
                                  ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS,
                                  ArrayList<CumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS) {
        this.annualRevenue = MathHelper.formatData(annualRevenue*100,2);
        this.baseAnnualRevenue = MathHelper.formatData(baseAnnualRevenue*100,2);
        this.alpha = alpha;
        this.beta = beta;
        this.sharpeRatio = sharpeRatio;
        this.maxDrawdown = MathHelper.formatData(maxDrawdown*100,2);
        this.cumulativeYieldGraphDataVOS = cumulativeYieldGraphDataVOS;
        this.baseCumulativeYieldGraphDataVOS = baseCumulativeYieldGraphDataVOS;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public double getBaseAnnualRevenue() {
        return baseAnnualRevenue;
    }

    public void setBaseAnnualRevenue(double baseAnnualRevenue) {
        this.baseAnnualRevenue = baseAnnualRevenue;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getSharpeRatio() {
        return sharpeRatio;
    }

    public void setSharpeRatio(double sharpeRatio) {
        this.sharpeRatio = sharpeRatio;
    }

    public double getMaxDrawdown() {
        return maxDrawdown;
    }

    public void setMaxDrawdown(double maxDrawdown) {
        this.maxDrawdown = maxDrawdown;
    }

    public ArrayList<CumulativeYieldGraphDataVO> getCumulativeYieldGraphDataVOS() {
        return cumulativeYieldGraphDataVOS;
    }

    public void setCumulativeYieldGraphDataVOS(ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS) {
        this.cumulativeYieldGraphDataVOS = cumulativeYieldGraphDataVOS;
    }

    public ArrayList<CumulativeYieldGraphDataVO> getBaseCumulativeYieldGraphDataVOS() {
        return baseCumulativeYieldGraphDataVOS;
    }

    public void setBaseCumulativeYieldGraphDataVOS(ArrayList<CumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS) {
        this.baseCumulativeYieldGraphDataVOS = baseCumulativeYieldGraphDataVOS;
    }
}
