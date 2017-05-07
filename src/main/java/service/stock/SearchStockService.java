package service.stock;


import bean.Stock;
import input.SearchInput;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface SearchStockService {

    public ArrayList<Stock> searchStock(SearchInput searchInput);

}
