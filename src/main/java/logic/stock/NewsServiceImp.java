package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import service.stock.NewsService;
import vo.stock.NewsVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class NewsServiceImp implements NewsService {

    private StockInfoDAO stockInfoDAO;

    @Override
    public ArrayList<NewsVO> getNews() {
        return null;
    }

    public StockInfoDAO getStockInfoDAO() {
        return stockInfoDAO;
    }

    public void setStockInfoDAO(StockInfoDAO stockInfoDAO) {
        this.stockInfoDAO = stockInfoDAO;
    }
}
