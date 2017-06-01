package logic.calculation;

import DAO.stockInfoDAO.QuotaDAO;
import DAO.stockInfoDAO.StockInfoDAO;
import bean.History;
import bean.Macd;
import bean.Stock;
import logic.tools.DateHelper;
import logic.tools.MathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/23.
 */
@Service
public class MacdCalculation {

    private static final int MACD_SHORT_PERIOD = 9;
    private static final int MACD_MID_PERIOD = 12;
    private static final int MACD_LONG_PERIOD = 26;
    public static final String DATE_INDEX = "2014-05-26";

    @Autowired
    private StockInfoDAO stockInfoDAO;

    @Autowired
    private QuotaDAO quotaDAO;

    public void start() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();

        while(codes.hasNext()) {
            this.calculateMACD(codes.next());
        }
    }

    /**
     * DIF:EMA(CLOSE,12)-EMA(CLOSE,26);
     * DEA:EMA(DIF,9);
     * MACD:(DIF-DEA)*2;
     *
     * 1、计算移动平均值（EMA）
     * 12日EMA的算式为
     * EMA（12）=前一日EMA（12）×11/13＋今日收盘价×2/13
     * 26日EMA的算式为
     * EMA（26）=前一日EMA（26）×25/27＋今日收盘价×2/27
     *
     * 2、计算离差值（DIF）
     * DIF=今日EMA（12）－今日EMA（26）
     *
     * 3、计算DIF的9日EMA
     * 根据离差值计算其9日的EMA,即离差平均值,是所求的MACD值.为了不与指标原名相混淆,此值又名DEA或DEM.
     * 今日DEA=前一日DEA×8/10＋今日DIF×2/10
     * 今日MACD = (DIF-DEA)*2
     * 计算出的DIF和DEA的数值均为正值或负值.
     */
    private void calculateMACD(String code) {
        ArrayList<SimpleStock> stocks = initStocks(code);

System.out.println("*************************************************** " + code + " size:" + stocks.size());

        boolean canSaveToDB = false;

        double ema12 = stocks.get(0).getClose();
        double ema26 = stocks.get(0).getClose();
        double dea = stocks.get(0).getClose();
        double diff;

        for(int i=1; i<stocks.size(); ++i) {

            double close = stocks.get(i).getClose();

            ema12 = ema12 * (1 - getK(MACD_MID_PERIOD)) + close * getK(MACD_MID_PERIOD);
            ema26 = ema26 * (1 - getK(MACD_LONG_PERIOD)) + close * getK(MACD_LONG_PERIOD);
            diff = ema12 - ema26;
            dea = dea * (1 - getK(MACD_SHORT_PERIOD)) + diff * getK(MACD_SHORT_PERIOD);

            if (!canSaveToDB && DateHelper.calculateDaysBetween(DATE_INDEX, stocks.get(i).getDate()) >= 0) {
                canSaveToDB = true;
            }

            //保存至数据库
            if (canSaveToDB) {
                Macd macd = new Macd();
                macd.setCode(code);
                macd.setDate(stocks.get(i).getDate());
                macd.setDiff(MathHelper.formatData(diff,2));
                macd.setDea(MathHelper.formatData(dea,2));
                macd.setMacd(MathHelper.formatData((diff-dea) * 2, 2));
//                quotaDAO.addMACD(macd);

System.out.println("*************************************************** " + code + " " + macd.getDate() + "  diff:" + macd.getDiff() + " dea:" + macd.getDea() + "  macd:" + macd.getMacd());

            }
        }
    }

    private double getK(int period) {
        double result = 2.0 / (period + 1.0);
        return result;
    }

    private ArrayList<SimpleStock> initStocks(String code) {
        Iterator<History> beforeStocks = stockInfoDAO.getHistory(code);
        Iterator<Stock> afterStocks = stockInfoDAO.getStockInfo(code);

        ArrayList<SimpleStock> stocks = new ArrayList<>();
        History history;
        Stock stock;

        while(beforeStocks.hasNext()) {
            history = beforeStocks.next();
            stocks.add(new SimpleStock(history.getCode(), history.getDate().substring(0, 10), history.getClose()));
        }

        while(afterStocks.hasNext()) {
            stock = afterStocks.next();
            stocks.add(new SimpleStock(stock.getStockId(), stock.getDate(), stock.getClose()));
        }

        assert (stocks.size() != 0) : "!!!MACD!!!股票代码" + code + "-数据有问题!!!";

        return stocks;
    }
}
