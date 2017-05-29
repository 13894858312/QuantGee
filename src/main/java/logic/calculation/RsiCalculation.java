package logic.calculation;

import DAO.stockInfoDAO.QuotaDAO;
import DAO.stockInfoDAO.StockInfoDAO;
import bean.History;
import bean.Rsi;
import bean.Stock;
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
public class RsiCalculation {

    private static final int INDEX1 = 6;
    private static final int INDEX2 = 12;
    private static final int INDEX3 = 24;

    private int dataStartIndex;

    @Autowired
    private StockInfoDAO stockInfoDAO;

    @Autowired
    private QuotaDAO quotaDAO;

    public void start() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();

        while(codes.hasNext()) {
            this.calculateRSI(codes.next());
        }
    }

    private void calculateRSI(String code) {
        ArrayList<SimpleStock> stocks = initStocks(code);

        double rsi6, rsi12, rsi24;

        for (int i=dataStartIndex; i<stocks.size(); ++i) {
            if (i < 26) {
                continue;
            } else {
                rsi6 = rsi(stocks, i, INDEX1);
                rsi12 = rsi(stocks, i, INDEX2);
                rsi24 = rsi(stocks, i, INDEX3);
            }

            Rsi rsi = new Rsi();
            rsi.setCode(code);
            rsi.setDate(stocks.get(i).getDate());
            rsi.setRsi6(MathHelper.formatData(rsi6,3));
            rsi.setRsi12(MathHelper.formatData(rsi12,3));
            rsi.setRsi24(MathHelper.formatData(rsi24,3));

            quotaDAO.addRSI(rsi);
        }
    }

    /**
     * RSI的计算指标公式为，RSI=100－100÷（1+相对强度RS）
     */
    private double rsi(ArrayList<SimpleStock> stocks, int nowIndex, int period) {
        double result, up=0, down=0;
        int start = nowIndex - period;

        for (int i=start; i<nowIndex; ++i) {
            double temp = stocks.get(i+1).getClose() - stocks.get(i).getClose();
            if(temp > 0) {
                up += temp;
            } else {
                down += temp;
            }
        }

        double rs = up/down;

        result = 100 - 100/(1 + rs);

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
            stocks.add(new SimpleStock(history.getStockId(), history.getDate().substring(0, 10), history.getClose()));
        }

        //记录5-26所在的index
        dataStartIndex = stocks.size();

        while(afterStocks.hasNext()) {
            stock = afterStocks.next();
            stocks.add(new SimpleStock(stock.getStockId(), stock.getDate(), stock.getClose()));
        }

        assert (stocks.size() != 0) : "!!!RSI!!!股票代码" + code + "-数据有问题!!!";

        return stocks;
    }

}
