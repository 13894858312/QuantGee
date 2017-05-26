package logic.calculation;

/**
 * Created by Mark.W on 2017/5/24.
 */
public class BpPredict {

    private static double[][] maxmin;
    private static final int PREDICT_INTERVAL = 5;

    public static void main(String[] args) {
        new BpPredict().start();
    }

    private void start() {
        //初始化神经网络的基本配置
        //第一个参数是一个整型数组，表示神经网络的层数和每层节点数，比如{3,10,10,10,10,2}表示输入层是3个节点，输出层是2个节点，中间有4层隐含层，每层10个节点
        //第二个参数是学习步长，第三个参数是动量系数
        BpNet bp = new BpNet(new int[]{5, 12, 12, 1}, 0.15, 0.8);

        //2017-02-16-2017-05-05
        //设置样本数据，对应上面的4个二维坐标数据
        double[] close = new double[]{9.46, 9.39, 9.56, 9.57, 9.51, 9.5, 9.43, 9.48, 9.49, 9.43,
                9.4, 9.45, 9.42, 9.38, 9.4, 9.44, 9.48, 9.52, 9.31, 9.25,
                9.24, 9.16, 9.2, 9.19, 9.14, 9.12, 9.11, 9.08, 9.17, 9.21,
                9.2, 9.18, 9.15, 9.12, 9.08, 9.1, 9.05, 8.91, 8.92, 8.97};
        double[][] data = dataNormalize(close, true);

        //设置目标数据，对应4个坐标数据的分类
        bp.train(data);

        //根据训练结果来检验样本数据
        for (int j = 0; j < data.length; j++) {
            double[] result = bp.computeOut(data[j]);
            System.out.println("1 actual:" + (result[0] * (maxmin[j][0]- maxmin[j][1]) + maxmin[j][1]) + "     expected:" + close[j+5]);
        }

        double[] testClose1= new double[]{8.93, 9, 8.99, 8.97, 8.99};
        double[][] data1 = dataNormalize(testClose1, false);
        for (int i = 0; i<data1.length; ++i) {
            double[] result = bp.computeOut(data1[i]);
            System.out.println("2  actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "     expected: 8.94");
        }


        double[] testClose2= new double[]{9, 8.99, 8.97, 8.99, 8.94};
        double[][] data2 = dataNormalize(testClose2, false);
        for (int i = 0; i<data2.length; ++i) {
            double[] result = bp.computeOut(data2[i]);
            System.out.println("3  actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "     expected: 8.91");
        }

        double[] testClose3= new double[]{8.99, 8.97, 8.99, 8.94,8.91};
        double[][] data3 = dataNormalize(testClose3, false);
        for (int i = 0; i<data3.length; ++i) {
            double[] result = bp.computeOut(data3[i]);
            System.out.println("4  actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "     expected: 8.74");
        }

        double[] testClose4= new double[]{8.97, 8.99, 8.94,8.91,8.74};
        double[][] data4 = dataNormalize(testClose4, false);
        for (int i = 0; i<data4.length; ++i) {
            double[] result = bp.computeOut(data4[i]);
            System.out.println("5  actual:" + (result[0] * (maxmin[i][0]- maxmin[i][1]) + maxmin[i][1]) + "     expected: 8.63");
        }
    }


    public double[][] dataNormalize(double[] close, boolean isTraining) {
        double[][] data;
        if (isTraining) {
            data = new double[close.length-PREDICT_INTERVAL][6];
        } else {
            data = new double[1][PREDICT_INTERVAL];
        }

        for (int i = 0;i<data.length; ++i) {
            for (int j=0; j<data[0].length; ++j) {
                data[i][j] = close[i+j];
            }
        }

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
}
