package logic.indexCalculation;

import DAO.stockInfoDAO.StockInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/23.
 */
@Service
public class BOLLCalculation {

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
     * MB = I - 1日MA
     * UP = MB + 2 * MD
     * DN = MB - 2 * MD
     */
    private void calculateBOLL(String next) {

    }
}
