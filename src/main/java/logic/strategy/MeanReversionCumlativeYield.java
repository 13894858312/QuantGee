package logic.strategy;

import vo.BaseCumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphVO;

import java.util.ArrayList;

/**
 * 均值回归策略累计收益率图
 * Created by Mark.W on 2017/4/4.
 */
public class MeanReversionCumlativeYield {
    private StockPool stockPool;

    private ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;  //每天的收益率
    private ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS; //基准收益率

    private CumulativeYieldGraphVO cumulativeYieldGraphVO;

    public MeanReversionCumlativeYield(StockPool stockPool) {
        this.stockPool = stockPool;
    }

    public void start(){

    }

    public CumulativeYieldGraphVO getCumulativeYieldGraphVO() {
        return cumulativeYieldGraphVO;
    }
}
