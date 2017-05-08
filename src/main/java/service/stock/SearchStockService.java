package service.stock;


import bean.Stock;
import form.SearchForm;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface SearchStockService {

    /**
     * 搜索股票
     * @param searchForm 股票输入
     * @return ArrayList<Stock>
     */
    public ArrayList<Stock> searchStock(SearchForm searchForm);

}
