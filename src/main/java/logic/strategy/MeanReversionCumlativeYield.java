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

    private int holdingPeriod;  //持有期
    private int returnPeriod;    //形成期
    private int holdingStockNum;  //每个持有期持有的股票数量

    private ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;  //每天的收益率
    private ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS; //基准收益率

    private CumulativeYieldGraphVO cumulativeYieldGraphVO;

    public MeanReversionCumlativeYield(StockPool stockPool, int holdingPeriod, int returnPeriod, int holdingStockNum) {
        this.stockPool = stockPool;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;
    }

    public void start(){

    }

    public CumulativeYieldGraphVO getCumulativeYieldGraphVO() {
        return cumulativeYieldGraphVO;
    }
}
