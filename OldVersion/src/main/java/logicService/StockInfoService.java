package logicService;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/4/19.
 */
public interface StockInfoService {
    /**
     * 获取所有股票的名字和代码
     * @return 股票名字和代码
     */
    public ArrayList<String> getAllStockInfo();
}
