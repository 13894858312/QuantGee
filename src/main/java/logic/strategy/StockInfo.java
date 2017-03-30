package logic.strategy;

import logic.tools.DateHelper;
import po.StockPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/29.
 * 策略计算时保存一种股票指定区间信息的类
 */
public class StockInfo {
    private int index;

    private String stockCode;
    private StockPO beforeStockPO;
    private ArrayList<StockPO> stockPOS;

    public StockInfo(Date startDate, String stockCode, ArrayList<StockPO> stockPOS) {
        this.beforeStockPO = stockPOS.get(0);
        this.stockCode = stockCode;

        this.initIndex(startDate);
    }


    //初始化index
    private void initIndex(Date startDate) {
        for(int i=0; i<stockPOS.size(); ++i) {
            String d = DateHelper.getInstance().dateTransToString(startDate);
            if(stockPOS.get(i).getDate().equals(d)) {
                this.index = i;
                break;
            }
        }
    }

    public StockPO getBeforeStockPO() {
        return beforeStockPO;
    }



    //
//    public StockPO getStockInfoOnSpecificDay(Date d) {
//        String da = DateHelper.getInstance().dateTransToString(today);
//        if(this.stockPOS.get(index).getDate().equals(da)) {
//            return stockPOS.get(index);
//        }
//
//        return null;
//    }
//
//    /**
//     * 回测第一次调整时 获取时间范围之前returnPeriod天的股票信息
//     * @param returnPeriod 形成期
//     * @return StockPO
//     */
//    public StockPO getBeforeTimeRangeStockInfo(int returnPeriod) {
//        return null;
//    }
}
