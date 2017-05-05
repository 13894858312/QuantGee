package DAO.stockInfoDAO;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface StockInfoDAO {

    /**
     * 根据股票名获取股票码
     * @param stockName 股票名
     * @return ArrayList<StockPO>
     */
    public String getStockCodeByName(String stockName);

}
