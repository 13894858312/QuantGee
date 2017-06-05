package logic.calculation;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Stock;
import logic.tools.MathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/24.
 * bp网络运行入口
 */
@Service
public class BpPredict {

    @Autowired
    private StockInfoDAO stockInfoDAO;

    private static final String START_DATE = "2017-01-01";
    private static final String END_DATE = "2017-05-01";

    private static double[][] maxmin;

    public void start() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();

        while(codes.hasNext()) {
            trainBpNet(codes.next());
        }
    }

    private void trainBpNet(String code) {

        double[] close  = initStocks(code, START_DATE, END_DATE);
        if (close.length == 0) {
            return;
        }

        BpNet bp = new BpNet(new int[]{5, 10,10, 1}, 0.15, 0.8);

        double[][] data = dataNormalize(close, true, bp.getPredict_interval());

        bp.train(data);

        DAO.getInstance().saveBpNet(code, bp);


System.out.println("/*******************************************检验样本数据*********************************************/");
for (int i = 0; i < data.length; i++) {
    double[] result = bp.computeOut(data[i]);
    double actual = result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1];
    double expected = close[i+5];
    System.out.println("****TRAIN-DATA****  code:" + code +  "  actual:" + actual + "   expected:" + expected +
            "   deviation:" + MathHelper.formatData((actual-expected)/expected * 100, 2) + "%");
}
System.out.println("/*******************************************检验样本数据*********************************************/");



System.out.println("/*******************************************检验新数据*********************************************/");
double[] sourceclose1 = initStocks(code, "2017-04-24", "2017-05-26");

for (int i=0; i<sourceclose1.length-(bp.getPredict_interval()+1); ++i) {
    double[] temp = new double[5];
    for (int j=i; j<i+5; ++j) {
        temp[j-i] = sourceclose1[j];
    }

    double[][] data1 = dataNormalize(temp, false, bp.getPredict_interval());

    for (int k = 0; k<data1.length; ++k) {
        double[] result = bp.computeOut(data1[k]);
        System.out.println("*****NEW-DATA*****  code:" + code +  "  actual:" + (result[0] * (maxmin[k][0]- maxmin[k][1]) + maxmin[k][1]) + "   expected:" + sourceclose1[i+5] +
                "   deviation:" + MathHelper.formatData(((result[0] * (maxmin[k][0]- maxmin[k][1]) + maxmin[k][1]) -  sourceclose1[i+5])/sourceclose1[i+5] * 100,2) + "%");
    }
}

System.out.println("/*******************************************检验新数据*********************************************/");

    }

    /**
     * 获取某段历史时期的股票用于训练
     * @param code 股票代码
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return double[]
     */
    private double[] initStocks(String code, String startDate, String endDate) {
        Iterator<Stock> sourceStocks = stockInfoDAO.getStockInfo(code, startDate, endDate);

        ArrayList<SimpleStock> stocks = new ArrayList<>();
        Stock stock;

        while (sourceStocks.hasNext()) {
            stock = sourceStocks.next();
            stocks.add(new SimpleStock(stock.getCode(), stock.getDate(), stock.getClose()));
        }

       double[] result = new double[stocks.size()];
        for (int i=0; i<result.length; ++i) {
            result[i] = stocks.get(i).getClose();
        }

        return result;
    }



    /**
     * 数据处理成二维数组并归一化
     * @param close 收盘价
     * @param isTraining 是否是训练数据
     * @return double[][]
     */
    private double[][] dataNormalize(double[] close, boolean isTraining, int interval) {
        double[][] data;
        if (isTraining) {
            data = new double[close.length-interval][6];
        } else {
            data = new double[1][interval];
        }

        for (int i = 0;i<data.length; ++i) {
            for (int j=0; j<data[0].length; ++j) {
                data[i][j] = close[i+j];
            }
        }

        //更新最大最小值的数组
        maxmin = new double[data.length][2];
        for (int i = 0; i< maxmin.length; ++i) {
            double max=data[i][0], min=max;
            for (int j=1; j<data[i].length; ++j) {
                max = Math.max(data[i][j], max);
                min = Math.min(data[i][j], min);
            }
            maxmin[i][0]=max;
            maxmin[i][1]=min;
        }


        for (int i=0; i<data.length; ++i) {
            for (int j=0; j<data[0].length; ++j) {
                data[i][j] = (data[i][j] - maxmin[i][1])/ (maxmin[i][0]- maxmin[i][1]);
            }
        }

        return data;
    }

    /**
     * 在数组尾添加一个数字
     * @param close 数组
     * @param number 数组
     * @return double[]
     */
    private double[] appendArray(double[] close, double[] number) {
        double[] result = new double[close.length+number.length];

        for (int i=0; i<close.length; ++i) {
            result[i] = close[i];
        }

        for (int i=close.length; i<result.length; ++i) {
            result[i] = number[i-close.length];
        }

        return result;
    }

    /**
     * 在数组尾添加一个数字
     * @param close 数组
     * @param number 数字
     * @return double[]
     */
    private double[] appendNumber(double[] close, double number) {
        double[] result = new double[close.length+1];

        for (int i=0; i<close.length; ++i) {
            result[i] = close[i];
        }

        result[result.length-1] = number;

        return result;
    }

}
