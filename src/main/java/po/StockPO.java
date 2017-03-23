package po;


/**
 * Created by Mark.W on 2017/3/5.
 */
public class StockPO {

    private String date;
    private double openPrice;
    private double maxValue;
    private double minValue;
    private double closePrice;
    private int volume;
    private double ADJ;
    private String stockCode;
    private String stockName;
    private String stockMarket;

    private String blockName;

    /**
     * @param date 日期
     * @param openPrice 开盘价
     * @param maxValue 最高值
     * @param minValue 最低值
     * @param closePrice 收盘价
     * @param ADJ 复权后的收盘指数
     * @param volume 成交量
     * @param stockCode 股票代码
     * @param stockName  股票名称
     * @param stockMarket 市场名称
     * @param blockName 板块名字
     */
    public StockPO(String date, double openPrice, double maxValue, double minValue,
                   double closePrice,int volume, double ADJ,  String stockCode,
                   String stockName, String stockMarket, String blockName) {
        this.date = date;
        this.openPrice = openPrice;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.closePrice = closePrice;
        this.volume = volume;
        this.ADJ = ADJ;
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockMarket = stockMarket;
        this.blockName = blockName;
    }

    public int getCodeNumber() {
        int number = Integer.parseInt(this.stockCode);
        return number;
    }


    @Override
    public String toString() {
    	return "data:"+date+"	openPrice:"+openPrice+"	maxValue:"+maxValue+"	minValue:"+minValue+
    			"	closePrice:"+closePrice+"	volume:"+volume+"	ADJ:"+ADJ+"	stockCode:"+stockCode+
    			"	stockName:"+stockName+"	stockMarket:"+stockMarket;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getADJ() {
        return ADJ;
    }

    public void setADJ(double ADJ) {
        this.ADJ = ADJ;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

    public String getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(String stockMarket) {
        this.stockMarket = stockMarket;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

}
