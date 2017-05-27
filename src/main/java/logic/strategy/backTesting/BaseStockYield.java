package logic.strategy.backTesting;

/**
 * Created by Mark.W on 2017/5/27.
 */
public class BaseStockYield {
    private String date;
    private double baseYield;

    public BaseStockYield(String date, double baseYield) {
        this.date = date;
        this.baseYield = baseYield;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBaseYield() {
        return baseYield;
    }

}
