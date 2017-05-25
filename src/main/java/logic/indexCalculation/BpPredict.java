package logic.indexCalculation;

/**
 * Created by Mark.W on 2017/5/24.
 */
public class BpPredict {

    private static double[][] trainDataMaxmin;
    private static double[] maxmin = new double[2];

    public static void main(String[] args) {
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

        double[][] sourceData = new double[close.length-5][6];
        for (int i = 0;i<sourceData.length; ++i) {
            for (int j=0; j<sourceData[0].length; ++j) {
                sourceData[i][j] = close[i+j];
            }
        }

        double[][] data = trainDataNormalize(sourceData);

        //设置目标数据，对应4个坐标数据的分类
        bp.train(data);

        //根据训练结果来检验样本数据
        for (int j = 0; j < sourceData.length; j++) {
            double[] result = bp.computeOut(data[j]);
            System.out.println("one actual:" + (result[0] * (trainDataMaxmin[j][0]- trainDataMaxmin[j][1]) + trainDataMaxmin[j][1]) + "     expected:" + close[j+5]);
        }


        double[] testClose1= new double[]{8.93, 9, 8.99, 8.97, 8.99};
        double[] result1 = bp.computeOut(normalize(testClose1));
        System.out.println("two actual:" + (result1[0] * (maxmin[0]- maxmin[1]) + maxmin[1]) + "     expected: 8.94");

        double[] testClose2= new double[]{9, 8.99, 8.97, 8.99, 8.94};
        double[] result2 = bp.computeOut(normalize(testClose2));
        System.out.println("two actual:" + (result2[0] * (maxmin[0]- maxmin[1]) + maxmin[1]) + "     expected: 8.91");

        double[] testClose3= new double[]{8.99, 8.97, 8.99, 8.94,8.91};
        double[] result3 = bp.computeOut(normalize(testClose3));
        System.out.println("two actual:" + (result3[0] * (maxmin[0]- maxmin[1]) + maxmin[1]) + "     expected: 8.74");

        double[] testClose4= new double[]{8.97, 8.99, 8.94,8.91,8.74};
        double[] result4 = bp.computeOut(normalize(testClose4));
        System.out.println("two actual:" + (result4[0] * (maxmin[0]- maxmin[1]) + maxmin[1]) + "     expected: 8.63");

    }


    public static double[] normalize(double[] data) {

        double max = data[0], min = max;
        for (int j = 1; j < data.length; ++j) {
            max = Math.max(data[j], max);
            min = Math.min(data[j], min);
        }

        maxmin[0] = max;
        maxmin[1] = min;

        for (int i = 0; i < data.length; ++i) {
             data[i] = (data[i] - maxmin[1]) / (maxmin[0] - maxmin[1]);
        }

        return data;
    }

    public static double[][] trainDataNormalize(double[][] data) {
        trainDataMaxmin = new double[data.length][2];
        for (int i = 0; i< trainDataMaxmin.length; ++i) {
            double max=data[i][0], min=max;
            for (int j=1; j<data[i].length; ++j) {
                max = Math.max(data[i][j], max);
                min = Math.min(data[i][j], min);
            }
            trainDataMaxmin[i][0]=max;
            trainDataMaxmin[i][1]=min;
        }

        for (int i=0; i<data.length; ++i) {
            for (int j=0; j<data[0].length; ++j) {
                data[i][j] = (data[i][j] - trainDataMaxmin[i][1])/ (trainDataMaxmin[i][0]- trainDataMaxmin[i][1]);
            }
        }

        return data;
    }
}
