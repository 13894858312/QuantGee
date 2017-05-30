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

System.out.println("*************************************************** " + code + " size:" + stocks.size() + " dataStartIndex:" + dataStartIndex);

        double rsi6, rsi12, rsi24;

        for (int i=dataStartIndex; i<stocks.size(); ++i) {
            if (i < INDEX3) {
                continue;
            } else {
                rsi6 = rsi(stocks, i, INDEX1);
                rsi12 = rsi(stocks, i, INDEX2);
                rsi24 = rsi(stocks, i, INDEX3);
            }

            Rsi rsi = new Rsi();
            rsi.setCode(code);
            rsi.setDate(stocks.get(i).getDate());
            rsi.setRsi6(MathHelper.formatData(rsi6,2));
            rsi.setRsi12(MathHelper.formatData(rsi12,2));
            rsi.setRsi24(MathHelper.formatData(rsi24,2));

//            quotaDAO.addRSI(rsi);

System.out.println("*************************************************** " + code + " " + rsi.getDate() + "  rsi6:" + rsi.getRsi6() + " rsi12:" + rsi.getRsi12() + "  rs24:" + rsi.getRsi24());

        }
    }

    /**
     * 假设A为N日内收盘价的正数之和，B为N日内收盘价的负数之和乘以(—1)
     * RSI(N)=A÷(A＋B)×100
     */
    private double rsi(ArrayList<SimpleStock> stocks, int nowIndex, int period) {
        double result, up=0, down=0;

        int start = nowIndex - period;
        for (int i=start; i<nowIndex; ++i) {
            double temp = stocks.get(i+1).getClose() - stocks.get(i).getClose();
            if(temp > 0) {
                up += temp;
            } else {
                down -= temp;
            }
        }

        result = up / (up + down) * 100;

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
