package logic.calculation;

import DAO.stockInfoDAO.QuotaDAO;
import DAO.stockInfoDAO.StockInfoDAO;
import bean.Boll;
import bean.History;
import bean.Stock;
import logic.tools.MathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/23.
 */
@Service
public class BollCalculation {
    private static final int PERIOD = 20;
    private int dataStartIndex;

    @Autowired
    private QuotaDAO quotaDAO;

    @Autowired
    private StockInfoDAO stockInfoDAO;

    public void start() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();

        while(codes.hasNext()) {
            this.calculateBOLL(codes.next());
        }
    }

    /**
     * 1．计算MA
     * MA = 最近N日累计收盘价 / N日
     * 2．计算MD
     * MD =平方根 (最近N日累计(收盘价 - MA) * (收盘价 - MA)`/N)
     * 3．计算MB、UP、DN
     * MB = N日MA
     * UP = MB + 2 * MD
     * DN = MB - 2 * MD
     */
    private void calculateBOLL(String code) {
        ArrayList<SimpleStock> stocks = initStocks(code);

System.out.println("*************************************************** " + code + " size:" + stocks.size() + " dataStartIndex:" + dataStartIndex);

        double mb, md;

        for (int i=dataStartIndex; i<stocks.size(); ++i) {
            if (i < PERIOD) {
                continue;
            } else {
                mb = ma(stocks, i, PERIOD);
                md = md(stocks, i, PERIOD, mb);
            }

            Boll boll = new Boll();
            boll.setCode(code);
            boll.setDate(stocks.get(i).getDate());
            boll.setMid(MathHelper.formatData(mb,2));
            boll.setUp(MathHelper.formatData(mb+2*md,2));
            boll.setLow(MathHelper.formatData(mb-2*md,2));
//            quotaDAO.addBOLL(boll);

System.out.println("*************************************************** " + code + " " + boll.getDate() + "  mid:" + boll.getMid() + " up:" + boll.getUp() + "  low:" + boll.getLow());


        }


    }

    private double md(ArrayList<SimpleStock> stocks, int nowIndex, int period, double mb) {
        double result = 0;
        int start = nowIndex - period + 1;

        for (int i=start; i<=nowIndex; ++i) {
            result += Math.pow((stocks.get(i).getClose()-mb), 2);
        }

        result = Math.sqrt(result/period);
        return result;
    }


    //计算指定某一天的均线值
    private double ma(ArrayList<SimpleStock> stocks, int nowIndex, int period) {
        int start = nowIndex - period + 1;
        double result = 0;

        for (int i=start; i<=nowIndex; ++i) {
            result += stocks.get(i).getClose();
        }

        return result/period;
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

        //记录5-26所在的index
        dataStartIndex = stocks.size();

        while(afterStocks.hasNext()) {
            stock = afterStocks.next();
            stocks.add(new SimpleStock(stock.getCode(), stock.getDate(), stock.getClose()));
        }

        assert (stocks.size() != 0) : "!!!BOLL!!!股票代码" + code + "-数据有问题!!!";

        return stocks;
    }
}
