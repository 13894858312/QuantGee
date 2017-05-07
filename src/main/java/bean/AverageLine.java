package bean;

/**
 * Created by Administrator on 2017/5/7.
 */
public class AverageLine {
    /**
     * stockName    股票名称
     * averageDate  对应均线数据
     * averageType  均线类型
     */
    private String stockName;
    private String averageDate;
    private AverageType averageType;

    public String getStockName(){
        return stockName;
    }

    public void setStockName(String stockName){
        this.stockName = stockName;
    }

    public String getAverageDate(){
        return averageDate;
    }

    public void setAverageDate(String averageDate){
        this.averageDate = averageDate;
    }
}
