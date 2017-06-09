package vo.strategy;


/**
 * Created by Mark.W on 2017/6/7.
 */
public class StrategyTradeRecordVO {
    private String code;
    private String buyDate;
    private String sellDate;
    private double buyMoney;
    private double sellMoney;
    private double rate;

    /**
     * @param code 股票代码
     * @param buyDate 买入时间
     * @param sellDate 卖出时间
     * @param buyMoney 交易金钱
     * @param sellMoney 交易金钱
     */
    public StrategyTradeRecordVO(String code, String buyDate, String sellDate, double buyMoney, double sellMoney) {
        this.code = code;
        this.buyDate = buyDate;
        this.sellDate = sellDate;
        this.buyMoney = buyMoney;
        this.sellMoney = sellMoney;
        this.rate = (sellMoney-buyMoney)/buyMoney;
    }

    public String getCode() {
        return code;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public String getSellDate() {
        return sellDate;
    }

    public double getBuyMoney() {
        return buyMoney;
    }

    public double getSellMoney() {
        return sellMoney;
    }

    public double getRate() {
        return rate;
    }
}
