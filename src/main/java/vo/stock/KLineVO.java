package vo.stock;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/5.
 * k线图数据
 */
public class KLineVO {

    private String stockCode;
    private String stockName;
    private ArrayList<KLineDataVO> kLineDataVOS;

    public KLineVO() {}

    /**
     * @param stockCode 股票代码
     * @param stockName 股票名称
     * @param kLineDataVOS k线图具体数据
     */
    public KLineVO(String stockCode, String stockName, ArrayList<KLineDataVO> kLineDataVOS) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.kLineDataVOS = kLineDataVOS;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public ArrayList<KLineDataVO> getkLineDataVOS() {
        return kLineDataVOS;
    }

    public void setkLineDataVOS(ArrayList<KLineDataVO> kLineDataVOS) {
        this.kLineDataVOS = kLineDataVOS;
    }
}
