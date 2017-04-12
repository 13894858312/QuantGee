package vo;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 累计收益率图的信息类
 */
public class CumulativeYieldGraphVO {
    public double annualRevenue;       //年化收益率
    public double baseAnnualRevenue;  //基准年化收益率
    public double alpha;
    public double beta;
    public double sharpeRatio;  //夏普比率
    public double maxDrawdown;  //最大回撤
    public ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;       //策略收益率
    public ArrayList<CumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS; //基准收益率

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
        this.annualRevenue = annualRevenue;
        this.baseAnnualRevenue = baseAnnualRevenue;
        this.alpha = alpha;
        this.beta = beta;
        this.sharpeRatio = sharpeRatio;
        this.maxDrawdown = maxDrawdown;
        this.cumulativeYieldGraphDataVOS = cumulativeYieldGraphDataVOS;
        this.baseCumulativeYieldGraphDataVOS = baseCumulativeYieldGraphDataVOS;
    }
}
