package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Current;
import bean.Stock;
import logic.tools.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.stock.MarketInfoService;
import vo.stock.MarketInfoVO;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MarketInfoServiceImp implements MarketInfoService{

    @Autowired
    private StockInfoDAO stockInfoDAO;

    @Override
    public MarketInfoVO getRealTimeMarketInfo(String marketType) {
        return getHistoryMarketInfo(marketType, DateHelper.getNowDate());
    }


    @Override
    public MarketInfoVO getHistoryMarketInfo(String marketType, String date) {

//        boolean isRealTime = false;
//        if (DateHelper.getNowDate().equals(date)) {
//            isRealTime = true;
//        }
//
//        Iterator<String> codes = stockInfoDAO.getAllStockCodesByBlock(marketType);
//
//        double rate;
//        int[] rateNums = new int[6]; //数据依次为跌停，-10%- -5%，-5%-0，0-5%，5%-10%，涨停
//
//        while (codes.hasNext()) {
//            String code = codes.next();
//
//            //然后获取属于该板块的股票数据 计算涨跌幅股票的数量
//            if(isRealTime) {
//                Current temp = stockInfoDAO.getStockRealTimeInfo(code);
//                if (temp == null) {
//                    continue;
//                }
//                rate = temp.getChangepercent();
//            } else {
//                Stock temp = stockInfoDAO.getStockInfo(code, date);
//                if (temp == null) {
//                    continue;
//                }
//                rate = temp.getpChange();
//            }
//
//            //ST股不同判断条件 判断指定日期板块的股票涨跌幅情况
//            if (code.startsWith("ST")) {
//                if (rate <= -0.05) {
//                    rateNums[0]++;
//                } else if (rate >= -0.05 && rate < 0) {
//                    rateNums[2]++;
//                } else if (rate > 0 && rate <= 0.05) {
//                    rateNums[3]++;
//                } else if (rate >= 0.05) {
//                    rateNums[5]++;
//                }
//            } else {
//                if (rate <= -0.1) {
//                    rateNums[0]++;
//                } else if (rate > -0.1 && rate < -0.05) {
//                    rateNums[1]++;
//                } else if (rate >= -0.05 && rate < 0) {
//                    rateNums[2]++;
//                } else if (rate > 0 && rate <= 0.05) {
//                    rateNums[3]++;
//                } else if (rate > 0.05 && rate < 0.1) {
//                    rateNums[4]++;
//                } else if (rate >= 0.1) {
//                    rateNums[5]++;
//                }
//            }
//        }
//
//        MarketInfoVO result;
//
//        //首先获取该板块在指定时间的基础数据
//        if(isRealTime) {
//            Current current = stockInfoDAO.getStockRealTimeInfo(marketType);
//            result = new MarketInfoVO(date, DateHelper.getNowTime(), marketType, current.getTrade(), current.getVolume(), rateNums);
//        } else {
//            Stock s = stockInfoDAO.getStockInfo(marketType, date);
//            result = new MarketInfoVO(date, marketType, s.getVolume(), rateNums);
//        }
//
//        return result;
        return null;
    }
}
