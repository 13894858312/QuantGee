package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.stock.PredictStockService;
import vo.stock.*;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/21.
 */
@Service
public class PredictStockServiceImp implements PredictStockService {

//    private static final int MACD_SHORT_PERIOD = 9;
//    private static final int MACD_MID_PERIOD = 12;
//    private static final int MACD_LONG_PERIOD = 26;
//
//    @Autowired
//    private StockInfoDAO stockInfoDAO;
//
//    /**
//     * 默认参数为 MACD(12,26,9)
//     * MACD的计算方法
//     * DIFF : EMA(CLOSE,SHORT) - EMA(CLOSE,LONG);
//     * DEA  : EMA(DIFF,MID);
//     * MACD : 2*(DIFF-DEA), COLORSTICK;
//     */
//    @Override
//    public ArrayList<MACD> getMACDInfo(StockInputVO inputVO) {
//
//        ArrayList<MACD> MACDS = stockInfoDAO.getMACDs(inputVO.getStartDate(), inputVO.getEndDate(), inputVO.getStockCode());
//        if (MACDS == null || MACDS.size() == 0) {
//            return null;
//        }
//
//        ArrayList<MACD> result = new ArrayList<>();
//
//        for(MACD MACD : MACDS) {
//            result.add(new MACD(MACD.getDate(), MACD.getCode(), MACD.getDiff(), MACD.getDea(), MACD.getMacd()));
//        }
//
//        return result;
//    }
//
//    //默认参数为 KDJ(9,3,3)
//    @Override
//    public ArrayList<KDJ> getKDJInfo(StockInputVO inputVO) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<RSI> getRSIInfo(StockInputVO inputVO) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<BOLL> getBOLLInfo(StockInputVO inputVO) {
//        return null;
//    }
//
//    /**
//     * 计算EMA
//     * @param closePrice 收盘价序列
//     * @return ema
//     */
//    public double calculateEMA(double[] closePrice, int number) {
//        // 开始计算EMA值
//        double k = 2.0 / (number + 1.0);
//        //第一天ema等于当天收盘价
//        double ema = closePrice[0];
//        for (int i = 1; i < closePrice.length; i++) {
//            // 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
//            ema = closePrice[i] * k + ema * (1 - k);
//        }
//        return ema;
//    }

//    public static final Double getEXPMA(final List<Double> list, final int number) {
//        // 开始计算EMA值，
//        Double k = 2.0 / (number + 1.0);// 计算出序数
//        Double ema = list.get(0);// 第一天ema等于当天收盘价
//        for (int i = 1; i < list.size(); i++) {
//            // 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
//            ema = list.get(i) * k + ema * (1 - k);
//        }
//        return ema;
//    }
//
//    public static final HashMap<String, Double> getMACD(final List<Double> list, final int shortPeriod, final int longPeriod, int midPeriod) {
//        HashMap<String, Double> macdData = new HashMap<String, Double>();
//        List<Double> diffList = new ArrayList<Double>();
//        Double shortEMA = 0.0;
//        Double longEMA = 0.0;
//        Double dif = 0.0;
//        Double dea = 0.0;
//
//        for (int i = list.size() - 1; i >= 0; i--) {
//            List<Double> sublist = list.subList(0, list.size() - i);
//            shortEMA = Indicators.getEXPMA(sublist, shortPeriod);
//            longEMA = Indicators.getEXPMA(sublist, longPeriod);
//            dif = shortEMA - longEMA;
//            diffList.add(dif);
//        }
//        dea = Indicators.getEXPMA(diffList, midPeriod);
//        macdData.put("DIF", dif);
//        macdData.put("DEA", dea);
//        macdData.put("MACD", (dif - dea) * 2);
//        return macdData;
//    }
}
