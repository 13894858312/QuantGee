package vo.stock;


import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/5.
 * 均线图的信息
 */
public class AverageLineVO {
    private String stockCode;
    private String stockName;
    private AverageLineType averageLineType;
    private ArrayList<AverageLineDataVO> averageLineDataVOS;

    public AverageLineVO() {}

    /**
     * @param stockCode 股票代码
     * @param stockName 股票名称
     * @param averageLineType 类型
     * @param averageLineDataVOS 均线图每日具体数据
     */
    public AverageLineVO(String stockCode, String stockName, AverageLineType averageLineType,
                         ArrayList<AverageLineDataVO> averageLineDataVOS) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.averageLineType = averageLineType;
        this.averageLineDataVOS = averageLineDataVOS;
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

    public AverageLineType getAverageLineType() {
        return averageLineType;
    }

    public void setAverageLineType(AverageLineType averageLineType) {
        this.averageLineType = averageLineType;
    }

    public ArrayList<AverageLineDataVO> getAverageLineDataVOS() {
        return averageLineDataVOS;
    }

    public void setAverageLineDataVOS(ArrayList<AverageLineDataVO> averageLineDataVOS) {
        this.averageLineDataVOS = averageLineDataVOS;
    }
}
