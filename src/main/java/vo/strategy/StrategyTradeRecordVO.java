package vo.strategy;

import logic.tools.MathHelper;

/**
 * Created by Mark.W on 2017/6/7.
 */
public class StrategyTradeRecordVO {
    private String date;
    private String code;
    private int action;
    private double money;
    private double price;

    /**
     * @param date 时间
     * @param code 股票代码
     * @param action 操作类型 0 买入 1卖出
     * @param money 交易金钱
     * @param price 交易时的股价
     */
    public StrategyTradeRecordVO(String date, String code,int action, double money, double price) {
        this.date = date;
        this.code = code;
        this.money = MathHelper.formatData(money,2);
        this.price = price;
        this.action = action;
    }

    public String getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public double getMoney() {
        return money;
    }

    public double getPrice() {
        return price;
    }

    public int getAction() {
        return action;
    }
}
