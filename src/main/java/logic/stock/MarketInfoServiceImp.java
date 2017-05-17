package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Stock;
import logic.tools.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import service.stock.MarketInfoService;
import vo.stock.MarketInfoVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class MarketInfoServiceImp implements MarketInfoService{

    @Autowired
    private StockInfoDAO stockInfoDAO;

    @Override
    public MarketInfoVO getRealTimeMarketInfo(String marketType) {
        return getHistoryMarketInfo(marketType, DateHelper.getNowDate());
    }


    @Override
    public MarketInfoVO getHistoryMarketInfo(String marketType, String date) {

        boolean isRealTime = false;
        if (DateHelper.getNowDate().equals(date)) {
            isRealTime = true;
        }

        //首先获取该板块在指定时间的基础数据
        Stock stock = null;
        if(isRealTime) {
            stock = stockInfoDAO.getStockRealTimeInfo(marketType);
        } else {
            stock = stockInfoDAO.getStockInfo(marketType, date);
        }

        Iterator<String> codes = stockInfoDAO.getAllStockCodesByBlock(marketType);
        if (codes == null) {
            return null;
        }

        Stock temp = null;
        double rate = 0;

        int[] rateNums = new int[6]; //数据依次为跌停，-10%- -5%，-5%-0，0-5%，5%-10%，涨停

        while (codes.hasNext()) {
            String code = codes.next();
            //然后获取属于该板块的股票数据 计算涨跌幅股票的数量
            if(isRealTime) {
                temp = stockInfoDAO.getStockRealTimeInfo(code);
            } else {
                temp = stockInfoDAO.getStockInfo(code, date);
            }

            if (temp == null) {
                continue;
            }
            rate = temp.getpChange();

            //ST股不同判断条件 判断指定日期板块的股票涨跌幅情况
            if (temp.getStockId().startsWith("ST")) {
                if (rate <= -0.05) {
                    rateNums[0]++;
                } else if (rate >= -0.05 && rate < 0) {
                    rateNums[2]++;
                } else if (rate > 0 && rate <= 0.05) {
                    rateNums[3]++;
                } else if (rate >= 0.05) {
                    rateNums[5]++;
                }
            } else {
                if (rate <= -0.1) {
                    rateNums[0]++;
                } else if (rate > -0.1 && rate < -0.05) {
                    rateNums[1]++;
                } else if (rate >= -0.05 && rate < 0) {
                    rateNums[2]++;
                } else if (rate > 0 && rate <= 0.05) {
                    rateNums[3]++;
                } else if (rate > 0.05 && rate < 0.1) {
                    rateNums[4]++;
                } else if (rate >= 0.1) {
                    rateNums[5]++;
                }
            }
        }

        /*************************************************
         ******时间信息无法确定,实时指数price无法确定**********
         *************************************************/
        String time = "";
        if(isRealTime) {
            time = "00:00:00";
        }

        MarketInfoVO result = new MarketInfoVO(date, time, marketType, 0, stock.getVolume(), rateNums);

        return result;
    }

    public StockInfoDAO getStockInfoDAO() {
        return stockInfoDAO;
    }

    public void setStockInfoDAO(StockInfoDAO stockInfoDAO) {
        this.stockInfoDAO = stockInfoDAO;
    }
}
