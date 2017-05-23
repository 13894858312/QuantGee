package logic.stock;

import logic.tools.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.MACDPO;
import service.stock.PredictStockService;
import service.stock.StockBasicInfoService;
import vo.stock.*;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/21.
 */
@Service
public class PredictStockServiceImp implements PredictStockService {

    private static final int MACD_SHORT_PERIOD = 9;
    private static final int MACD_MID_PERIOD = 12;
    private static final int MACD_LONG_PERIOD = 26;

    /**
     * 默认参数为 MACD(12,26,9)
     * MACD的计算方法
     * DIFF : EMA(CLOSE,SHORT) - EMA(CLOSE,LONG);
     * DEA  : EMA(DIFF,MID);
     * MACD : 2*(DIFF-DEA), COLORSTICK;
     */
    @Override
    public ArrayList<MACDVO> getMACDInfo(StockInputVO inputVO) {

        this.updateMACD();

        return null;
    }

    private void updateMACD() {


        ArrayList<MACDPO> macdpos = new ArrayList<>();

    }

    //默认参数为 KDJ(9,3,3)
    @Override
    public ArrayList<KDJVO> getKDJInfo(StockInputVO inputVO) {
        return null;
    }

    @Override
    public ArrayList<RSIVO> getRSIInfo(StockInputVO inputVO) {
        return null;
    }

    @Override
    public ArrayList<BOLLVO> getBOLLInfo(StockInputVO inputVO) {
        return null;
    }
//
//    /**
//     * 计算EMA
//     * @param closePrice 收盘价序列
//     * @return ema
//     */
//    public double calculateEMA(ArrayList<StockHistoricalVO> stocks, int nowIndex, int period) {
//        // 开始计算EMA值
//        double k = 2.0 / (period + 1.0);
//        //第一天ema等于当天收盘价
//        double ema = stocks.get(nowIndex-period).getClose();
//
//        for (int i = nowIndex-period + 1; i < nowIndex; i++) {
//            // 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
//            ema = closePrice[i] * k + ema * (1 - k);
//        }
//        return ema;
//    }

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
//    /**
//     * Calculate EMA,
//     *
//     * @param list
//     *            :Price list to calculate，the first at head, the last at tail.
//     * @return
//     */
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
//    /**
//     * calculate MACD values
//     *
//     * @param list
//     *            :Price list to calculate，the first at head, the last at tail.
//     * @param shortPeriod
//     *            :the short period value.
//     * @param longPeriod
//     *            :the long period value.
//     * @param midPeriod
//     *            :the mid period value.
//     * @return
//     */
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
