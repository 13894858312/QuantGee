package vo.strategy;


import logic.tools.MathHelper;

/**
 * Created by Mark.W on 2017/6/7.
 */
public class StrategyTradeRecordVO {
    private String code;
    private String buyDate;
    private String sellDate;
    private double buyMoney;
    private double sellMoney;
    private int type;
    private double rate;

    /**
     * @param code 股票代码
     * @param buyDate 买入时间
     * @param sellDate 卖出时间
     * @param buyMoney 交易金钱
     * @param sellMoney 交易金钱
     * @param type 类型 0:正常 1:止损卖出 2:止盈卖出
     */
    public StrategyTradeRecordVO(String code, String buyDate, String sellDate, double buyMoney, double sellMoney,int type) {
        this.code = code;
        this.buyDate = buyDate;
        this.sellDate = sellDate;
        this.buyMoney = MathHelper.formatData(buyMoney, 2);
        this.sellMoney = MathHelper.formatData(sellMoney,2);
        this.type = type;
        this.rate = MathHelper.formatData((sellMoney-buyMoney)/buyMoney,2);
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

    public int getType() {
        return type;
    }
}
