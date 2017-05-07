package service.searchStock;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface SearchStockService {

    public String searchStock();

    //模糊搜索

    public String searchStockByBlock();

    public String searchStockByIndustry();
}
