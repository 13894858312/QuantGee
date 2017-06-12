package vo.trade;


/**
 * Created by Mark.W on 2017/5/11.
 * 对于每个用户当前所有在模拟交易的信息的vo
 */
public class HoldingStockVO {
    private String stockCode;
    private String stockName;
    private String userId;
    private int holdNum;

    private double nowPrice;
    private double initFund; //投入的本金
    private double yield;    //收益率

    public HoldingStockVO() {}

    /**
     * @param stockCode 股票代码
     * @param stockName 股票名字
     * @param userId 用户id
     * @param holdNum 股票股数
     * @param nowPrice 当前股票价格
     * @param initFund 初识资金即买入所花资金
     * @param yield 收益率
     */
    public HoldingStockVO(String stockCode,String stockName, String userId, int holdNum,
                          double nowPrice,double initFund, double yield) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.nowPrice = nowPrice;
        this.userId = userId;
        this.holdNum = holdNum;
        this.initFund = initFund;
        this.yield = yield;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getHoldNum() {
        return holdNum;
    }

    public void setHoldNum(int holdNum) {
        this.holdNum = holdNum;
    }

    public Double getInitFund() {
        return initFund;
    }

    public void setInitFund(Double initFund) {
        this.initFund = initFund;
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }

    public String getStockName() {
        return stockName;
    }

    public double getNowPrice() {
        return nowPrice;
    }
}
