package logic.calculation;

import DAO.stockInfoDAO.QuotaDAO;
import DAO.stockInfoDAO.StockInfoDAO;
import bean.History;
import bean.Kdj;
import bean.Stock;
import logic.tools.DateHelper;
import logic.tools.MathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Mark.W on 2017/5/23.
 */
@Service
public class KdjCalculation {
    private static final int INDEX1 = 9;
    private static final int INDEX2 = 3;
    private static final int INDEX3 = 3;

    @Autowired
    private StockInfoDAO stockInfoDAO;

    @Autowired
    private QuotaDAO quotaDAO;


    public void start() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();

        while(codes.hasNext()) {
            this.calculateKDJ(codes.next());
        }
    }

    /**
     * RSV(9)=（今日收盘价－9日内最低价）/（9日内最高价－9日内最低价）×100
     * K(3日)=（当日RSV值+2×前一日K值）/3
     * D(3日)=（当日K值+2×前一日D值）/3
     * J=3K－2D
     */
    private void calculateKDJ(String code) {
        ArrayList<SimpleStock> stocks = initStocks(code);

System.out.println(code + ":  size" + stocks.size());

        double k=50, d=50, j=50;
        boolean canSaveToDB = false;

        for (int i=0; i<stocks.size(); ++i) {
            k = (rsv(stocks, i) + 2 * k) / INDEX2;
            d = (k + 2 * d) / INDEX3;
            j = 3 * k - 2 * d;

            if (!canSaveToDB && DateHelper.calculateDaysBetween(MacdCalculation.DATE_INDEX, stocks.get(i).getDate()) >= 0) {
                canSaveToDB = true;
            }

            //保存至数据库
            if (canSaveToDB) {
                Kdj kdj = new Kdj();
                kdj.setCode(code);
                kdj.setDate(stocks.get(i).getDate());
                kdj.setK(MathHelper.formatData(k,3));
                kdj.setD(MathHelper.formatData(d,3));
                kdj.setJ(MathHelper.formatData(j,3));

//                quotaDAO.addKDJ(kdj);

System.out.println("     " + kdj.getDate() + " " + kdj.getK() + " " + kdj.getD() + " " + kdj.getJ());
            }
        }

    }

    private double rsv(ArrayList<SimpleStock> stocks, int nowIndex) {
        int start = nowIndex- INDEX1 + 1;
        if(start < 0) {
            start = 0;
        }

        double high = stocks.get(start).getHigh(),
                low = stocks.get(start).getLow(), rsv;
        for(int i=start+1; i<=nowIndex; ++i) {
            high = Math.max(high, stocks.get(i).getHigh());
            low = Math.min(low, stocks.get(i).getLow());
        }

        rsv = (stocks.get(nowIndex).getClose() - low) / (high - low) * 100;

        return rsv;
    }

    private ArrayList<SimpleStock> initStocks(String code) {
        Iterator<History> beforeStocks = stockInfoDAO.getHistory(code);
        Iterator<Stock> afterStocks = stockInfoDAO.getStockInfo(code);

        ArrayList<SimpleStock> stocks = new ArrayList<>();
        History history;
        Stock stock;

        while(beforeStocks.hasNext()) {
            history = beforeStocks.next();
            stocks.add(new SimpleStock(history.getStockId(), history.getDate().substring(0, 10), history.getClose(),
                    history.getHigh(), history.getLow()));
        }

        while(afterStocks.hasNext()) {
            stock = afterStocks.next();
            stocks.add(new SimpleStock(stock.getStockId(), stock.getDate(), stock.getClose(), stock.getHigh(), stock.getLow()));
        }

        assert (stocks.size() != 0) : "!!!KDJ!!!股票代码" + code + "-数据有问题!!!";

        return stocks;
    }

}
