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
    private int index; //当前访问到的arraylist的下表
    private Date today; //回测时的假定的当天时间
    private String stockCode;
    private ArrayList<StockPO> stockPOS;

    public StockInfo(Date today, String stockCode, ArrayList<StockPO> stockPOS) {
        this.today = today;
        this.stockCode = stockCode;
        this.stockPOS = stockPOS;

        this.initIndex();
    }

    //初始化index
    private void initIndex() {
        for(int i=0; i<stockPOS.size(); ++i) {
            String d = DateHelper.getInstance().dateTransToString(today);
            if(stockPOS.get(i).getDate().equals(d)) {
                this.index = i;
                break;
            }
        }
    }

    public StockPO getStockInfoOnSpecificDay(Date d) {
        String da = DateHelper.getInstance().dateTransToString(today);
        if(this.stockPOS.get(index).getDate().equals(da)) {
            return stockPOS.get(index);
        }

        return null;
    }

    /**
     * 回测第一次调整时 获取时间范围之前returnPeriod天的股票信息
     * @param returnPeriod 形成期
     * @return StockPO
     */
    public StockPO getBeforeTimeRangeStockInfo(int returnPeriod) {
        return null;
    }
}
