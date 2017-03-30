package logic.strategy;

import vo.*;
import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/29.
 * 动量策略
 */
public class MomentumDriveStrategy implements Strategy {

    private StockPool stockPool;

    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StrategyInputVO strategyInputVO) {

        stockPool = new StockPool(strategyInputVO);

        stockPool.start();

        ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS = stockPool.getCumulativeYieldGraphDataVOS();

        double annualRevenue = 0;       //年化收益率
        double baseAnnualRevenue = 0;  //基准年化收益率
        double alpha = 0;
        double beta = 0;
        double sharpeRatio = 0;  //夏普比率
        double maxDrawdown = 0;  //最大回撤





        CumulativeYieldGraphVO cumulativeYieldGraphVO = new CumulativeYieldGraphVO(annualRevenue,baseAnnualRevenue,
                alpha, beta,sharpeRatio, maxDrawdown,cumulativeYieldGraphDataVOS);

        return cumulativeYieldGraphVO;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {
        return null;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StrategyInputVO strategyInputVO) {
        return null;
    }



}
