package logic.calculation;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Stock;
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

        ArrayList<SimpleStock> stocks = initStocks(code, START_DATE, END_DATE);
        if (stocks.size() == 0) {
            return;
        }

        double[] close = new double[stocks.size()];
        for (int i=0; i<close.length; ++i) {
            close[i] = stocks.get(i).getClose();
        }

        BpNet bp = new BpNet(new int[]{5, 10, 10, 1}, 0.15, 0.8);

        double[][] data = dataNormalize(close, true, bp.getPredict_interval());

        bp.train(data);


/*****************根据训练结果来检验样本数据*******************/
for (int i = 0; i < data.length; i++) {
    double[] result = bp.computeOut(data[i]);
    System.out.println("****TRAIN-DATA****   actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "   expected:" + close[i+5]  + "   deviation:" + ((result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) - close[i+5]));
}
/*****************根据训练结果来检验样本数据*******************/


        double[] testClose1= new double[]{8.93, 9, 8.99, 8.97, 8.99};
        double actual1 = 8.94;
        double[][] data1 = dataNormalize(testClose1, false, bp.getPredict_interval());
        for (int i = 0; i<data1.length; ++i) {
            double[] result = bp.computeOut(data1[i]);
System.out.println("******************   actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "   expected:" + actual1 + "   deviation:" + ((result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) - actual1));
        }
    }

    /**
     * 获取某段历史时期的股票用于训练
     * @param code 股票代码
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return ArrayList<SimpleStock>
     */
    private ArrayList<SimpleStock> initStocks(String code, String startDate, String endDate) {
        Iterator<Stock> sourceStocks = stockInfoDAO.getStockInfo(code, START_DATE, END_DATE);

        ArrayList<SimpleStock> stocks = new ArrayList<>();
        Stock stock;

        while (sourceStocks.hasNext()) {
            stock = sourceStocks.next();
            stocks.add(new SimpleStock(stock.getCode(), stock.getDate(), stock.getClose()));
        }

        return stocks;
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

//    public void start() {
//        //初始化神经网络的基本配置
//        //第一个参数是一个整型数组，表示神经网络的层数和每层节点数，比如{3,10,10,10,10,2}表示输入层是3个节点，输出层是2个节点，中间有4层隐含层，每层10个节点
//        //第二个参数是学习步长，第三个参数是动量系数
//        BpNet bp = new BpNet(new int[]{5, 10, 10, 1}, 0.15, 0.8);
//
//        //设置样本数据，对应上面的4个二维坐标数据
//        double[] close = new double[]{9.46, 9.39, 9.56, 9.57, 9.51, 9.5, 9.43, 9.48, 9.49, 9.43,
//                9.4, 9.45, 9.42, 9.38, 9.4, 9.44, 9.48, 9.52, 9.31, 9.25,
//                9.24, 9.16, 9.2, 9.19, 9.14, 9.12, 9.11, 9.08, 9.17, 9.21,
//                9.2, 9.18, 9.15, 9.12, 9.08, 9.1, 9.05, 8.91, 8.92, 8.97};
//        double[][] data = dataNormalize(close, true);
//
//        bp.train(data);
//
//        /*****************根据训练结果来检验样本数据*******************/
//        for (int i = 0; i < data.length; i++) {
//            double[] result = bp.computeOut(data[i]);
//            System.out.println("****TRAIN-DATA****   actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "   expected:" + close[i+5]  + "   deviation:" + ((result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) - close[i+5]));
//        }
//        /*****************根据训练结果来检验样本数据*******************/
//
//
//
//
//        double[] testClose1= new double[]{8.93, 9, 8.99, 8.97, 8.99};
//        double actual1 = 8.94;
//        double[][] data1 = dataNormalize(testClose1, false);
//        for (int i = 0; i<data1.length; ++i) {
//            double[] result = bp.computeOut(data1[i]);
//            System.out.println("******************   actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "   expected:" + actual1 + "   deviation:" + ((result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) - actual1));
//        }
//
//
//        data = dataNormalize(appendNumber(testClose1, 8.94), true);
//        bp.train(data);
//
//
//        double[] testClose2= new double[]{9, 8.99, 8.97, 8.99, 8.94};
//        double actual2 = 8.91;
//        double[][] data2 = dataNormalize(testClose2, false);
//        for (int i = 0; i<data2.length; ++i) {
//            double[] result = bp.computeOut(data2[i]);
//            System.out.println("******************   actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "   expected:" + actual2 + "   deviation:" + ((result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) - actual2));
//        }
//
//
//        data = dataNormalize(appendNumber(testClose2, 8.91), true);
//        bp.train(data);
//
//
//        double[] testClose3= new double[]{8.99, 8.97, 8.99, 8.94,8.91};
//        double actual3 = 8.74;
//        double[][] data3 = dataNormalize(testClose3, false);
//        for (int i = 0; i<data3.length; ++i) {
//            double[] result = bp.computeOut(data3[i]);
//            System.out.println("******************   actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "   expected:" + actual3 + "   deviation:" + ((result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) - actual3));
//        }
//
//        data = dataNormalize(appendNumber(testClose3, 8.74), true);
//        bp.train(data);
//
//        double[] testClose4= new double[]{8.97, 8.99, 8.94,8.91,8.74};
//        double actual4 = 8.63;
//        double[][] data4 = dataNormalize(testClose4, false);
//        for (int i = 0; i<data4.length; ++i) {
//            double[] result = bp.computeOut(data4[i]);
//            System.out.println("******************   actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "   expected:" + actual4 + "   deviation:" + ((result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) - actual4));
//        }
//    }

}
