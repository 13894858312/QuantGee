package logic.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.stock.PredictStockService;
import service.stock.StockBasicInfoService;
import vo.stock.BOLLVO;
import vo.stock.KDJVO;
import vo.stock.MACDVO;
import vo.stock.RSIVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/21.
 */
@Service
public class PredictStockServiceImp implements PredictStockService {

    @Autowired
    private StockBasicInfoService stockBasicInfoService;

    /**
     * 默认参数为 MACD(12,26,9)
     * MACD的计算方法
     * DIFF : EMA(CLOSE,SHORT) - EMA(CLOSE,LONG);
     * DEA  : EMA(DIFF,M);
     * MACD : 2*(DIFF-DEA), COLORSTICK;
     */
    @Override
    public ArrayList<MACDVO> getMACDInfo(String stockCode) {
        return null;
    }

    //默认参数为 KDJ(9,3,3)
    @Override
    public ArrayList<KDJVO> getKDJInfo(String stockCode) {
        return null;
    }

    @Override
    public ArrayList<RSIVO> getRSIInfo(String stockCode) {
        return null;
    }

    @Override
    public ArrayList<BOLLVO> getBOLLInfo(String stockCode) {
        return null;
    }

    /**
     * 计算EMA
     * @param closePrice 收盘价序列
     * @return ema
     */
    public double calculateEXA(double[] closePrice, final int number) {
        // 开始计算EMA值，
        Double k = 2.0 / (number + 1.0);// 计算出序数
        Double ema = closePrice[0];// 第一天ema等于当天收盘价
        for (int i = 1; i < closePrice.length; i++) {
            // 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
            ema = closePrice[i] * k + ema * (1 - k);
        }
        return ema;
    }

//    /**
//     * 计算MACD
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
//    public HashMap<String, Double> calculateMACD(double[] c final int shortPeriod, final int longPeriod, int midPeriod) {
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
