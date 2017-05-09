package service.stock;


import bean.Stock;
import vo.stock.SearchVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface SearchStockService {

    /**
     * 搜索股票
     * @param searchVO 股票输入
     * @return ArrayList<Stock>
     */
    public ArrayList<Stock> searchStock(SearchVO searchVO);

}
