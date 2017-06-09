package logic.strategy.backTesting;

/**
 * Created by Mark.W on 2017/4/10.
 * 持有股票的信息
 */
public class LogicHoldingStock {
    private String code;
    private String date;
    private double numOfStock;
    private double money;

    private boolean canContinueHold;      //调仓时可否继续持有
    /**
     * @param code 股票代码
     * @param date 买入日期
     * @param numOfStock 持有股票数
     * @param money 初始投入的钱
     */
    public LogicHoldingStock(String code, String date, double numOfStock, double money) {
        this.code = code;
        this.date = date;
        this.numOfStock = numOfStock;
        this.money = money;
        this.canContinueHold = true;
    }

    public String getCode() {
        return code;
    }

    public double getNumOfStock() {
        return numOfStock;
    }

    public boolean isCanContinueHold() {
        return canContinueHold;
    }

    public double getMoney() {
        return money;
    }

    public void setCanContinueHold(boolean canContinueHold) {
        this.canContinueHold = canContinueHold;
    }

    public String getDate() {
        return date;
    }
}
