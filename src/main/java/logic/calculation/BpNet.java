package logic.calculation;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Mark.W on 2017/5/24.
 */
public class BpNet implements Serializable{

    private static final long serialVersionUID = 1L;

    private double[][] layer;//神经网络各层节点
    private double[][] layerErr;//神经网络各节点误差
    private double[][][] layer_weight;//各层节点权重
    private double[][][] layer_weight_delta;//各层节点权重动量
    private double mobp;//动量系数
    private double rate;//学习系数
    private int trainNum = 100000;

    private boolean trained = false;
    public int predict_interval;

    /**
     * 初始化神经网络的基本配置
     * @param layernum 一个整型数组，表示神经网络的层数和每层节点数，
     *                 比如{3,10,10,10,10,2}表示输入层是3个节点，输出层是2个节点，中间有4层隐含层，每层10个节点
     * @param rate 学习步长
     * @param mobp 动量系数
     */
    public BpNet(int[] layernum, double rate, double mobp) {
        this.predict_interval = layernum[0];
        this.mobp = mobp;
        this.rate = rate;
        layer = new double[layernum.length][];
        layerErr = new double[layernum.length][];
        layer_weight = new double[layernum.length][][];
        layer_weight_delta = new double[layernum.length][][];

        Random random = new Random();

        for (int k = 0; k < layernum.length; k++) {
            layer[k] = new double[layernum[k]];
            layerErr[k] = new double[layernum[k]];

            if (k + 1 < layernum.length) {

                layer_weight[k] = new double[layernum[k] + 1][layernum[k + 1]];
                layer_weight_delta[k] = new double[layernum[k] + 1][layernum[k + 1]];

                for (int j = 0; j < layernum[k] + 1; j++) {
                    for (int i = 0; i < layernum[k + 1]; i++) {
                        layer_weight[k][j][i] = random.nextDouble();//随机初始化权重
                    }
                }
            }
        }
    }

    //逐层向前计算输出
    public double[] computeOut(double[] in) {
        for (int k = 1; k < layer.length; k++) {
            for (int j = 0; j < layer[k].length; j++) {
                double z = layer_weight[k - 1][layer[k - 1].length][j];
                for (int i = 0; i < layer[k - 1].length; i++) {
                    layer[k - 1][i] = k == 1 ? in[i] : layer[k - 1][i];

                    z += layer_weight[k - 1][i][j] * layer[k - 1][i];
                }
                layer[k][j] = 1 / (1 + Math.exp(-z));
            }
        }
        return layer[layer.length - 1];
    }

    //逐层反向计算误差并修改权重
    public void updateWeight(double[] tar) {
        int k = layer.length - 1;

        for (int j = 0; j < layerErr[k].length; j++) {
            layerErr[k][j] = layer[k][j] * (1 - layer[k][j]) * (tar[j] - layer[k][j]);
        }


        while (k-- > 0) {
            for (int j = 0; j < layerErr[k].length; j++) {
                double z = 0.0;
                for (int i = 0; i < layerErr[k + 1].length; i++) {
                    z = z + k > 0 ? layerErr[k + 1][i] * layer_weight[k][j][i] : 0;
                    layer_weight_delta[k][j][i] = mobp * layer_weight_delta[k][j][i] + rate * layerErr[k + 1][i] * layer[k][j];//隐含层动量调整
                    layer_weight[k][j][i] += layer_weight_delta[k][j][i];//隐含层权重调整

                    if (j == layerErr[k].length - 1) {
                        layer_weight_delta[k][j + 1][i] = mobp * layer_weight_delta[k][j + 1][i] + rate * layerErr[k + 1][i];//截距动量调整
                        layer_weight[k][j + 1][i] += layer_weight_delta[k][j + 1][i];//截距权重调整
                    }
                }
                layerErr[k][j] = z * layer[k][j] * (1 - layer[k][j]);//记录误差
            }
        }
    }

    public void train(double[][] sourceData) {

        double[][] data = new double[sourceData.length][sourceData[0].length-1];
        double[][] tar = new double[sourceData.length][1];

        for (int i=0; i<sourceData.length; ++i) {
            for (int j=0; j<sourceData[0].length-1; ++j) {
                data[i][j] = sourceData[i][j];
            }
            //最后数字为预期结果
            tar[i][0] = sourceData[i][sourceData[0].length-1];
        }

        //迭代训练5000次
        for (int n = 0; n < trainNum; n++) {
            for (int i = 0; i < data.length; i++) {
                trainOnce(data[i], tar[i]);
            }
        }

        trained = true;
    }


    public void trainOnce(double[] in, double[] tar) {
        double[] out = computeOut(in);
        updateWeight(tar);
    }


    public int getPredict_interval() {
        return predict_interval;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }
}