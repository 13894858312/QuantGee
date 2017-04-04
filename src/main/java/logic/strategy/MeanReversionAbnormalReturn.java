package logic.strategy;

import vo.AbnormalReturnGraphDataVO;
import vo.AbnormalReturnGraphVO;

import java.util.ArrayList;

/**
 * 均值回归策略超额收益率图
 * Created by Mark.W on 2017/4/4.
 */
public class MeanReversionAbnormalReturn {
    private StockPool stockPool;

    private double period;
    private boolean isHoldingPeriod;

    private ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS;  //超额收益率和策略胜率图数据信息
    private AbnormalReturnGraphVO abnormalReturnGraphVO;

    public MeanReversionAbnormalReturn(StockPool stockPool, double period, boolean isHoldingPeriod) {
        this.stockPool = stockPool;
        this.period = period;
        this.isHoldingPeriod = isHoldingPeriod;
    }

    public void start() {

    }


    public AbnormalReturnGraphVO getAbnormalReturnGraphVO() {
        return abnormalReturnGraphVO;
    }
}
