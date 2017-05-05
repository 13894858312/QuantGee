package service.stock;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface StockInfoService {
    /**
     * 获取所有股票的名字和代码
     * @return 股票信息
     */
    public String getAllStockInfo();

    public String getStockInfoByCode(String stockCode);

    public String getCurrentStockInfo(String stockCode);
}
