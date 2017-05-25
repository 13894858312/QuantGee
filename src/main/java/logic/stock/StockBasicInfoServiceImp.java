package logic.stock;

import DAO.stockInfoDAO.QuotaDAO;
import DAO.stockInfoDAO.StockInfoDAO;
import bean.Current;
import bean.MarketInfo;
import bean.Stock;
import logic.tools.DateHelper;
import logic.tools.MathHelper;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.stock.StockBasicInfoService;
import vo.stock.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StockBasicInfoServiceImp implements StockBasicInfoService {

    @Autowired
    private StockInfoDAO stockInfoDAO;

    @Autowired
    private QuotaDAO quotaDAO;

    @Autowired
    private StockDataCalculation stockDataCalculation;

    @Autowired
    private TransferHelper transferHelper;

    @Override
    public StockCurrentVO getRealTimeStockInfo(String code) {
        MarketInfo marketInfo = stockInfoDAO.getMarketInfo(code);
        Current stock = stockInfoDAO.getStockRealTimeInfo(code);
        if(marketInfo == null || stock == null) {
            return null;
        }

        StockCurrentVO stockCurrentVO = transferHelper.transToStockCurrent(marketInfo, stock);

        return stockCurrentVO;
    }

    @Override
    public ArrayList<StockCurrentVO> getAllRealTimeStocks() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();
        return getStockCurrentVOs(codes);
    }

    @Override
    public ArrayList<StockCurrentVO> getStocksByIndustry(String industryName) {
        Iterator<String> codes = stockInfoDAO.getAllStockCodesByIndustry(industryName);
        return getStockCurrentVOs(codes);
    }

    @Override
    public ArrayList<StockHistoricalVO> getStockHistoricalInfo(StockInputVO inputVO) {
        if(inputVO == null) {
            return null;
        }

        MarketInfo marketInfo = stockInfoDAO.getMarketInfo(inputVO.getStockCode());
        Iterator<Stock> stocks = stockInfoDAO.getStockInfo(inputVO.getStockCode(),
                inputVO.getStartDate(), inputVO.getEndDate());

        ArrayList<StockHistoricalVO> result = new ArrayList<>();
        Stock stock = null, formerStock;

        while(stocks.hasNext()) {
            formerStock = stock;
            stock = stocks.next();

            StockHistoricalVO historicalVO = transferHelper.transToStockHistorical(marketInfo, stock);

            //k线图的数据
            KLineData kLineData = stockDataCalculation.calculateKLine(historicalVO);
            historicalVO.setPositive(kLineData.isPositive());
            historicalVO.setUpperShadow(kLineData.getUpperShadow());
            historicalVO.setLowerShadow(kLineData.getLowerShadow());

            //对数收益率
            if(formerStock != null && stock != null) {
                double logarithmYield = Math.log(stock.getClose() / formerStock.getClose());
                historicalVO.setLogarithmYield(logarithmYield);
            }

            result.add(historicalVO);
        }

        return result;
    }

    /**
     * 根据代码列表获取数据 用来方法服用
     * @param codes 代码
     * @return ArrayList<StockCurrentVO>
     */
    public ArrayList<StockCurrentVO> getStockCurrentVOs(Iterator<String> codes) {

        ArrayList<StockCurrentVO> result = new ArrayList<>();

        while(codes.hasNext()) {
            String code = codes.next();
            if(code != null && !code.equals("")) {
                result.add(getRealTimeStockInfo(code));
            }
        }

        if(result.size() == 0) {
            return null;
        }

        return result;
    }

}
