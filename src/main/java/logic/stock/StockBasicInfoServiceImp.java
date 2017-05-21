package logic.stock;

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
    private StockDataCalculation stockDataCalculation;

    @Autowired
    private TransferHelper transferHelper;


    @Override
    public ArrayList<StockCurrentVO> getAllRealTimeStocks() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();

        if(codes == null) {
            return null;
        }

        ArrayList<StockCurrentVO> stockCurrentVOS = new ArrayList<>();
        while(codes.hasNext()) {
            String code = codes.next();
            StockCurrentVO stockCurrentVO = getRealTimeStockInfo(code);
            stockCurrentVOS.add(stockCurrentVO);
        }

       return stockCurrentVOS;
    }

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
    public ArrayList<StockHistoricalVO> getStockHistoricalInfo(StockInputVO inputVO) {

        if(inputVO == null) {
            return null;
        }

        MarketInfo marketInfo = stockInfoDAO.getMarketInfo(inputVO.getStockCode());
        ArrayList<StockHistoricalVO> result = new ArrayList<>();
        Stock stock = null;
        Stock formerStock;

        Iterator<Stock> stocks = stockInfoDAO.getStockInfo(inputVO.getStockCode(),
                inputVO.getStartDate(), inputVO.getEndDate());

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

    @Override
    public ArrayList<StockCurrentVO> getStocksByIndustry(String industryName) {
        Iterator<String> codes = stockInfoDAO.getAllStockCodesByIndustry(industryName);
        if(codes == null) {
            return null;
        }

        ArrayList<StockCurrentVO> result = new ArrayList<>();

        while(codes.hasNext()) {
            String code = codes.next();
            StockCurrentVO currentVO = getRealTimeStockInfo(code);
            result.add(currentVO);
        }

        return result;
    }

    /**
     * 均线图是将每天的收盘价加权平均,从而得到一条带有趋势性的轨迹。
     * 在日 K 线图中一般白线、黄线、紫线、绿线、蓝线依次分别表示:5、10、20、30、60日移动平均线。
     * 移动平均线常用线有 5 天、10 天、30 天、60 天、120 天和 240 天的指标。
     * 其中，5天和10天的短期移动平均线。是短线操作的参照指标，称做日均线指标;
     * 30 天和 60 天的是中期均线指标，称做季均线指标;
     * 120 天、240 天的是长期均 线指标，称做年均线指标。
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param stockCode 股票代码
     * @param period 均线周期
     * @return
     */
    public ArrayList<MAVO> getAverageLineInfoByCode(String stockCode, String startDate, String endDate, int period) {

        if(period <= 0 || period > DateHelper.calculateDaysBetween(startDate, endDate)) {
            return null;
        }

        //如果总天数小于均线图的时间间隔出错
        Iterator<Stock> sourceStocks = stockInfoDAO.getStockInfo(stockCode, startDate, endDate);
        ArrayList<Stock> stocks = new ArrayList<>();
        while(sourceStocks.hasNext()) {
            stocks.add(sourceStocks.next());
        }

        if(period >= stocks.size()) {
            return null;
        }

        ArrayList<MAVO> result = new ArrayList<>();
        Stock stock = null;

        for (int i = period-1; i<stocks.size(); ++i){
            stock = stocks.get(i);

            double all = 0;
            for(int j=i-period+1; j<i+1; ++j) {
                all += stocks.get(j).getClose();
            }

            double average = MathHelper.formatData(all/(double)period, 4);

            result.add(new MAVO(stock.getStockId(),period, stock.getDate(), average));
        }

        return result;
    }

}
