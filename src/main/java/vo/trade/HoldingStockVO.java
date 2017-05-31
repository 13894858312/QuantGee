package vo.trade;


/**
 * Created by Mark.W on 2017/5/11.
 * 对于每个用户当前所有在模拟交易的信息的vo
 */
public class HoldingStockVO {
    private String stockCode;
    private String userId;
    private int holdNum;

    private Double initFund; //投入的本金
    private Double yield;    //收益率

    public HoldingStockVO() {}

    /**
     * @param stockCode 股票代码
     * @param userId 用户id
     * @param holdNum 股票股数
     * @param initFund 初识资金即买入所花资金
     * @param yield 收益率
     */
    public HoldingStockVO(String stockCode, String userId, int holdNum,
                          Double initFund, Double yield) {
        this.stockCode = stockCode;
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
}
