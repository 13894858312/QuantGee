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
    public double returnVolatility;  //收益波动率
    public double informationRatio;  //信息比率
    public double maxDrawdown;  //最大回撤
    public double turnoverRate;  //换手率
    public ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;

    /**
     * 收益率图
     * @param annualRevenue 年化收益率
     * @param baseAnnualRevenue 基准年化收益率
     * @param alpha alpha
     * @param beta beta
     * @param sharpeRatio 夏普比率
     * @param returnVolatility 收益波动率
     * @param informationRatio 信息比率
     * @param maxDrawdown 最大回撤
     * @param turnoverRate 换手率
     * @param cumulativeYieldGraphDataVOS 坐标信息
     */
    public CumulativeYieldGraphVO(double annualRevenue, double baseAnnualRevenue, double alpha,
                                  double beta, double sharpeRatio, double returnVolatility,
                                  double informationRatio, double maxDrawdown, double turnoverRate,
                                  ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS) {
        this.annualRevenue = annualRevenue;
        this.baseAnnualRevenue = baseAnnualRevenue;
        this.alpha = alpha;
        this.beta = beta;
        this.sharpeRatio = sharpeRatio;
        this.returnVolatility = returnVolatility;
        this.informationRatio = informationRatio;
        this.maxDrawdown = maxDrawdown;
        this.turnoverRate = turnoverRate;
        this.cumulativeYieldGraphDataVOS = cumulativeYieldGraphDataVOS;
    }
}
